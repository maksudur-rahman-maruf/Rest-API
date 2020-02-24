package io.javabrains.springbootstarter.Topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	
	@Autowired
	TopicsService topicsService;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics()
	{
		return topicsService.getAllTopics() ;
		
	}
	
	@RequestMapping("/topic/{id}")
	public Topics getTopic(@PathVariable String id)
	{
		return topicsService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topics topic)
	{
		topicsService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id)
	{
		topicsService.updateTopic(topic,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicsService.deleteTopic(id);
	}

}
