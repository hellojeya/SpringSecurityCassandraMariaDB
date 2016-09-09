package com.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.PlainTextAuthProvider;

@SpringBootApplication
//@EnableCassandraRepositories(basePackages = { "com.demo.model" } )
public class BootMariaCassandraApplication extends AbstractCassandraConfiguration{

	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(BootMariaCassandraApplication.class, args);
	}

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return environment.getProperty("spring.data.cassandra.keyspace-name");
	}
	
	@Bean	
	public	CassandraClusterFactoryBean cluster(){
		
		CassandraClusterFactoryBean clusterFactoryBean= new CassandraClusterFactoryBean();
		clusterFactoryBean.setContactPoints(environment.getProperty("spring.data.cassandra.contact-points"));
		clusterFactoryBean.setPort(Integer.parseInt(environment.getProperty("spring.data.cassandra.port")));
		clusterFactoryBean.setAuthProvider(authProvider());
		return clusterFactoryBean;
	}
	
	@Bean
	public PlainTextAuthProvider authProvider(){
		
		return new PlainTextAuthProvider("cassandra", "cassandra");
	}
	
	
	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException
	{
		return new BasicCassandraMappingContext();
	}
	
	@Override
	public SchemaAction getSchemaAction()
	{
		return SchemaAction.NONE;
	}

}
