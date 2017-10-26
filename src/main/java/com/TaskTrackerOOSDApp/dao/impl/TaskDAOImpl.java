package com.TaskTrackerOOSDApp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

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
		
		/* Created a local variable, tasklist, to be equal to our sql statement
		 * set result set variable and exceptions
		 * create new tasklist object and set values
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
			task.setStatus(rs.getString(3));
			task.setStatus(rs.getString(4));
			list.add(task);
		}
		return list;
}
		/* this looks horrible but gets rid of multiple errors */
});	
		return tasklist;
		}
}
