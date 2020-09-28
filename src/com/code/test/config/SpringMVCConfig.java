package com.code.test.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.code.test.dao.EmpDao;
import com.code.test.dao.EmpDaoImpl;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.code.test")
public class SpringMVCConfig implements WebMvcConfigurer {
	
	
	@Bean
	public ViewResolver getviewResolver() {
		InternalResourceViewResolver rs = new InternalResourceViewResolver();
		rs.setPrefix("/WEB-INF/jsp/");
		rs.setSuffix(".jsp");
		return rs;
		
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employee_db?serverTimeZone=UTC");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
		
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
		
	}
	
	@Bean
	public EmpDao getEmpDao() {
		EmpDaoImpl dao = new EmpDaoImpl();
		dao.setTemplate(getJdbcTemplate());
		return dao;
		
	}

}
