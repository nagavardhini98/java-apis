package com.spring.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.beans.Answers;
import com.spring.web.beans.QuestionForms;
import com.spring.web.beans.Quiz1;
import com.spring.web.beans.Registration;

import com.spring.web.service.UserService;
import com.spring.web.service.UserServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class UserController {

	@Autowired
	UserServiceImpl dao;
	
	//retrieving users 

	@RequestMapping("/user")

	public ResponseEntity<List<Registration>> viewUsers() {

		List<Registration> list = dao.getUsers();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	//retrieving user based on username

	@RequestMapping("/getUser/{username}/{password}")
    public @ResponseBody ResponseEntity<Registration> find(@PathVariable("username") String username,@PathVariable("password") String password)
    {
       Registration register=dao.find(username,password);
       
        System.out.print(username);
      return new ResponseEntity<>(register, HttpStatus.OK);    
    }

	//posting users data
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<Registration> createUser(@RequestBody Registration register) {
		int result = dao.save(register);

		System.out.print(register.getUsername());

		return new ResponseEntity<>(register, HttpStatus.OK);
	}

	//posting quiz data
	@RequestMapping(value = "/insertquiz", method = RequestMethod.POST)
	public ResponseEntity<Quiz1> createUser1(@RequestBody Quiz1 q1) {
		dao.save(q1);

		System.out.println(q1.getUserId());
		System.out.println(q1.isIsActive());
		System.out.print(q1.getQuizName());
		System.out.println(q1.getQuizSubject());
		System.out.println(q1.getQuizDesc());

		QuestionForms[] qf = q1.getQuestionforms();

		System.out.println(q1.getQuestionforms().length);

		for (int i = 0; i < qf.length; i++) {
			System.out.println(qf[i].getQuestion());
			System.out.println(qf[i].getAnswertype());

			Answers[] ans = qf[i].getAnswers();
			for (int j = 0; j < ans.length; j++) {
				System.out.println(ans[j].getAnsText());
				System.out.println(ans[j].isIscorrect());
			}

		}

		return new ResponseEntity<>(q1, HttpStatus.OK);
	}

//	@GetMapping("/findUser/{userName}")
//	
//	@ResponseBody ResponseEntity<String> find(@PathVariable("userName") String userName)
//	{​​​​
//		System.out.println(userName);
//	
//	return new ResponseEntity<String>("hey",HttpStatus.OK);
//	}
	
	
//	@RequestMapping("/findUser/{userName}")
//	public @ResponseBody ResponseEntity<String> findUser(@PathVariable("userName") String userName) {
//		//Registration register = dao.find(username);
//		System.out.print(userName);
//		return new ResponseEntity<String>("hey", HttpStatus.OK);
//	}
}
