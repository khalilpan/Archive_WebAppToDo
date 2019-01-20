package com.khalilpan.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.khalilpan.beans.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoIdCount = 1;

	static {
		todos.add(new Todo(todoIdCount++, "khalil", "buy Flowers", new Date(), false));
		todos.add(new Todo(todoIdCount++, "khalil", "call school", new Date(), false));
		todos.add(new Todo(todoIdCount++, "khalil", "project of pitang", new Date(), false));
	}

	// to retrieve all the todos for one specific user
	public List<Todo> getTodosForUser(String tempUser) {
		List<Todo> retrievedListTodoList = new ArrayList<Todo>();

		for (Todo tempTodo : todos) {
			if (tempTodo.getUser().equals(tempUser)) {
				retrievedListTodoList.add(tempTodo);
			}
		}
		return retrievedListTodoList;
	}

	// to add todo
	public boolean addTodo(String user, String description, Date targetDate, boolean isDone) {
		Todo todoToAdd = new Todo(todoIdCount++, user, description, targetDate, isDone);
		return todos.add(todoToAdd);
	}

	// to delete one todo
	public void deleteTodo(int idToDelete) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo tempTodo = iterator.next();
			if (tempTodo.getId() == idToDelete) {
				iterator.remove();
			}
		}

	}

	// to retrieve a todo from list
	public Todo retrieveTodo(int idToUpdate) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo tempTodo = iterator.next();
			if (tempTodo.getId() == idToUpdate) {
				return tempTodo;
			}
		}
		return null;

	}

	// to update a todo from list
	public void updateTodo(Todo todoToAddList) {

		deleteTodo(todoToAddList.getId());
		todos.add(todoToAddList);
		
	}

	// to return all the todos
	public List<Todo> getTodos() {
		return todos;
	}
}
