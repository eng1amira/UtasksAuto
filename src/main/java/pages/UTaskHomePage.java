package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class UTaskHomePage extends PageBase {
	public UTaskHomePage(WebDriver driver) {
		super(driver);
	}
	By link_addProject=By.xpath("//span[text()=\"Add Project\"]");
	By input_projName=By.xpath("//div[@class=\"add-project\"]//input");
	By btn_addProject=By.xpath("//div[@class=\"add-project\"]//button[text()=\"Add Project\"]");
	
	
	By link_addTask=By.xpath("//span[text()=\"Add Task\"]");
	By input_taskName=By.xpath("//div[@class=\"add-task__main\"]//input");
	By btn_addTask=By.xpath("//div[@class=\"add-task__main\"]//button[text()=\"Add Task\"]");
	By btn_taskDate=By.xpath("//div[@class=\"add-task__main\"]//span[@class=\"add-task__date\"]");
	
	
	
	public void addProject(String projectName) {
		clickElement(driver,link_addProject);
		setElement(driver,input_projName, projectName);
		clickElement(driver,btn_addProject);
		selectProject(projectName);
		
	}
	public void selectProject(String projectName) {
		clickElement(driver,By.xpath("//li//span[text()=\""+projectName+"\"]"));
	}
	public void addTask(String taskName, String dueDate) {
		clickElement(driver,link_addTask);
		setElement(driver,input_taskName, taskName);
	    clickElement(driver,btn_taskDate);
	    clickElement(driver,By.xpath("//li//span[text()=\""+dueDate+"\"]"));
		clickElement(driver,btn_addTask);
	}

}
