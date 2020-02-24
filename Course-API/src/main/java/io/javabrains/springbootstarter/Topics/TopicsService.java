package io.javabrains.springbootstarter.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicsService {

	private List<Topics> topics = new ArrayList<>(Arrays.asList(
			new Topics("Java","Head First Java", "A well descripted book"),
			new Topics("Spring","Spring in Actions", "A well descripted book"),
			new Topics("JavaScript","Modern Javascripts", "A well descripted book")	
			));
	
	public List<Topics> getAllTopics()
	{
		return topics;
	}

	public Topics getTopic(String id) {
		
		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		topics.add(topic);
		
	}

	public void updateTopic(Topics topic, String id) {
		for(int i=0; i<topics.size(); i++)
		{
			Topics t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
			}
			
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t-> t.getId().equals(id));
	}
}
