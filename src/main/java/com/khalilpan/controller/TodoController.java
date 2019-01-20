package com.khalilpan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.khalilpan.Service.TodoService;
import com.khalilpan.beans.Todo;

@RestController
//@SessionAttributes("userNameReceivedFromForm") // "userNameReceivedFromForm" is the name of ModelMap attribute
//"userNameReceivedFromForm" will be accessible in all the controllers that they put "@SessionAttributes" annotation in it
public class TodoController {

	@Autowired
	TodoService todoService;

	// with this annotation we will set a specific format for a date accross the
	// "TodoController" class
	@InitBinder
	protected void InitBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

	// http://lovalhost:8080/list-todos
	@GetMapping("/list-todos")
	public ModelAndView showTodoList(ModelMap modelMap) {

		String name = getLoggedUserName(modelMap);
		modelMap.put("todos", todoService.getTodosForUser(name));

		return new ModelAndView("list-todos");
	}

	// http://lovalhost:8080/add-todo
	@GetMapping("/add-todo")
	public ModelAndView showAddTodoPage(ModelMap modelMap) {
		String name = getLoggedUserName(modelMap);
		modelMap.put("todoToAdd", new Todo(0, name, " ", new Date(), false));
		return new ModelAndView("add-todo");
	}

	// "bindingResult" will be populated by result of validation
	// http://lovalhost:8080/add-todo
	@PostMapping("/add-todo")
	public ModelAndView addTodo(ModelMap modelMap, Todo todoReceived) {

		String username = getLoggedUserName(modelMap);
		todoService.addTodo(username, todoReceived.getDescription(), todoReceived.getTargetDate(), false);

		return new ModelAndView("redirect:/list-todos");
	}

	//getting usr name from spring security(the username that is entered by user in login page)
	private String getLoggedUserName(ModelMap modelMap) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	// http://lovalhost:8080/delete-todo
	@GetMapping("/delete-todo")
	public ModelAndView deleteTodo(@RequestParam int idToDeleteTodo) {
		todoService.deleteTodo(idToDeleteTodo);
		return new ModelAndView("redirect:/list-todos");
	}

	// http://lovalhost:8080/update-todo
	@GetMapping("/update-todo")
	public ModelAndView ShowTodoToUpdate(ModelMap modelMap, @RequestParam int idToUpdateTodo) {

		Todo todoToUpdate = todoService.retrieveTodo(idToUpdateTodo); // to get todo from list to put in modelMap

		modelMap.put("todoToUpdate", todoToUpdate); // it will populated with the same field names in the "jsp" form

		return new ModelAndView("update-todo");
	}

	// after pushing "Update" button in "jsp" form ,this method will run
	// http://lovalhost:8080/update-todo
	@PostMapping("/update-todo")
	public ModelAndView updateTodo(ModelMap modelMap, Todo todoForUpdate) {

		String username = getLoggedUserName(modelMap);
		todoForUpdate.setUser(username);// we are setting "user" because the "todo" that is mapped here from "jsp" is
										// withoud "user" field
		todoService.updateTodo(todoForUpdate);

		return new ModelAndView("redirect:/list-todos");
	}

}
