package com.TaskTrackerOOSDApp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.TaskTrackerOOSDApp.dao.TaskDAO;
import com.TaskTrackerOOSDApp.model.Task;

// public class task implements the DAO

public class TaskDAOImpl implements TaskDAO {

	// initiate or instantiate the JDBC Template
	private JdbcTemplate jdbcTemplate;

	// insert template to use JDBC and perform CRUD
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// annotate method with @override to set up spring remote

	@Override
	public List<Task> retrieveAlltasks() {
		// set up SQL code to send to query the table within the sql database
		String sql = "select * from task";

		/*
		 * Created a local variable, tasklist, to be equal to our sql statement set
		 * result set variable and exceptions create new tasklist object and set values
		 * returned list to tasklist then returned tasklist
		 */
		List<Task> tasklist = jdbcTemplate.query(sql, new ResultSetExtractor<List<Task>>() {
			public List<Task> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Task> list = new ArrayList<Task>();
				while (rs.next()) {
					Task task = new Task();
					task.setTaskId(rs.getInt(1));
					task.setTaskDescription(rs.getString(2));
					task.setAssignedTo(rs.getString(3));
					task.setStatus(rs.getString(4));
					list.add(task);
				}

				return list;
			}

		});
		return tasklist;
	}

	@Override
	public void createtask(Task task) {
		// SQL statement to insert the values into new line
		String sql = "INSERT INTO task (taskdesc, status, assignedto) VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] {task.getTaskDescription(), task.getStatus(), task.getAssignedTo()});
	}

	public Task retrieveOne(Integer taskId) {

		// SQL statement to retrieve one line based on TASK ID
		String sql = "SELECT * from task where ID = ?";
		Task task = (Task) jdbcTemplate.queryForObject(sql, new Object[] { taskId }, new RowMapper<Task>() {

			@Override
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				// create object to return from fields in database
				Task task = new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskDescription(rs.getString(2));
				task.setAssignedTo(rs.getString(3));
				task.setStatus(rs.getString(4));
				return task;

			}

		});
		return task;

	}

	@Override
	//Public method titled "updateTask" with  assigned 
	
	public void updateTask(Task task) {
		// Statement implement update task class updates status and field "assignedTo"
		// and retrieves data from overridden method in the Service Layer to change
		// default to user name
		String sql = "UPDATE task SET status=?, assignedto=? where ID = ?";
		jdbcTemplate.update(sql, new Object[] { task.getStatus(), task.getAssignedTo(), task.getTaskId() });

	}
}
