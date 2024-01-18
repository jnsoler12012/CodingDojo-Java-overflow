package com.nicolas.overflow.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.overflow.models.Answer;
import com.nicolas.overflow.models.NewQuestion;
import com.nicolas.overflow.models.Question;
import com.nicolas.overflow.models.Tag;
import com.nicolas.overflow.repositories.AnswerRepository;
import com.nicolas.overflow.repositories.QuestionRepository;
import com.nicolas.overflow.repositories.TagRepository;


@Service
public class AppService {
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private TagRepository tagRepo;

	public List<Question> findAllQuestions() {
		return questionRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public Question createQuestion(NewQuestion q) {
		List<Tag> tempTags = new ArrayList<Tag>();
		for (String subject: q.splitTags()) {
			Tag tag = tagRepo.findBySubject(subject).orElse(null);
			if (tag == null) {
				tag = new Tag(subject);
				tagRepo.save(tag);
			}
			if (!tempTags.contains(tag)) {
				tempTags.add(tag);
			}
		}
		Question question = new Question(q.getQuestion(), tempTags);
		return questionRepo.save(question);
	}
	

	public Answer createAnswer(Answer a) {
		return answerRepo.save(a);
	}
	
}
