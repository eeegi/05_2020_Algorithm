package EngineerInKorea;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * 회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은 특정 프로젝트가 완료 되어야만
 * 진행 할 수 있는 프로젝트가 있다. 프로젝트 목록과 각 프로젝트 간 의존 여부를 넘겨주면 의존도에 입각하는 프로젝트의 진행순서를
 * 반환하는 함수를 구현하시오.
 * 
 * 
 * Map<String, String> map = new HashMap<String, String>();
	map.put("a", "aaa");
	map.put("b", "bbb");
	map.put("c", "ccc");
	 
       //1번 : Java 1.8부터 가능
      	target.forEach((key, value)->{
          System.out.println( String.format("키 -> %s, 값 -> %s", key, value) );
      	});
      	
     	// 방법1)
		for ( String key : map.keySet() ) {
		    System.out.println("방법1) key : " + key +" / value : " + map.get(key));
		}
		System.out.println("=======================");
		 
		// 방법2)
		for ( Map.Entry<String, String> entry : map.entrySet() ) {
		    System.out.println("방법2) key : " + entry.getKey() +" / value : " + entry.getKey());
		}
		System.out.println("=======================");
		
		//iterating over keys only
		for (Integer key : map.keySet()) {
		    System.out.println("Key = " + key);
		}
		 
		//iterating over values only
		for (Integer value : map.values()) {
		    System.out.println("Value = " + value);
		}
		 
		// 방법3)
		Iterator<String> keys = map.keySet().iterator();
		while ( keys.hasNext() ) {
	    String key = keys.next();
	    System.out.println("방법3) key : " + key +" / value : " + map.get(key));
 */
public class Graph_GetTheDataFromGraph {

	public static void main(String[] argues) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {{"f", "a"}, {"f", "b"}, {"f", "c"},
				{"b", "a"}, {"c", "a"}, {"a", "e"}, {"b", "e"}, {"d", "e"}};
		ProjectManager pm = new ProjectManager(projects, dependencies);
		Project[] ps = pm.buildOrder();
		for (Project p : ps) {
			if (p != null) {
				System.out.print(p.getName() + " ");
			}
		}
	}
}

class Project {
	private String name;
	private LinkedList<Project> dependencies;
	private boolean marked;
	
	public Project(String name) {
		this.name = name;
		this.marked = false;
		this.dependencies = new LinkedList<Project>();
	}
	
	public void addDependancy(Project project) {
		if (!dependencies.contains(project)) {
			dependencies.add(project);
		}
	}
	public LinkedList<Project> getDependencies() {
		return this.dependencies;
	}
	
	public String getName() {
		return this.name;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public boolean getMarked() {
		return this.marked;
	}
}

class ProjectManager {
	private HashMap<String, Project> projects;
	public ProjectManager(String[] names, String[][] dependencies) {
		buildProject(names);
		addDependencies(dependencies);
	}
	public void buildProject(String[] names) {
		projects = new HashMap<String, Project>();
		for (int i = 0; i < names.length; i++) {
			projects.put(names[i],new Project(names[i]));
		}
	}
	public void addDependencies(String[][] dependencies) {
		for (String[] dependency : dependencies) {
			Project before = findProject(dependency[0]);
			Project after = findProject(dependency[1]);
			after.addDependancy(before);
		}
	}
	private int index;
	public Project[] buildOrder() {
		initMarkingFlags();
		Project[] ordered = new Project[this.projects.size()];
		index = 0;
		for (Project project : this.projects.values()) {
			buildOrder(project, ordered);
		}
		return ordered;
	}
	public void buildOrder(Project project, Project[] ordered) {
		if (!project.getDependencies().isEmpty()) {
			for (Project p : project.getDependencies()) {
				buildOrder(p,  ordered);
			}
		}
		if (project.getMarked() == false) {
			project.setMarked(true);
			ordered[index] = project;
			index++;
		}
	}
	private void initMarkingFlags() {
		for (Project project: this.projects.values()) {
			project.setMarked(false);;
		}
	}
	public Project findProject(String name) {
		return projects.get(name);
	}
}
