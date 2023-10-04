package com.inchel.oct043.human;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.inchel.oct043.cat.Cat;
import com.inchel.oct043.dog.Dog;

public class Human {

	private String name;
	private int age;
	
	//배열을 포함한 컬렉션이 들어간 클래스
	private String[] nickname;
	private ArrayList<String> friend;
	private HashMap<String, Integer> family;
	
	//Has A(의존?) 관계의 클래스 객체 선언
	
	private Dog pet;
	
	//.xml에 등록한 고양이 객체과 자동으로 연결시켜주는 Autowired 어노테이션 사용
	//자동으로 연결해주기 때문에, 생성자와 setter가 필요없다.
	//그래서 아래에서 생성자와 setter에서, Autowired로 들어간 애들은 전부 빼도록 할 예정.(진짜 없어도 되는지 보려고)
	@Autowired
	private Cat pet2;
	
	@Autowired
	private Cat pet3;
	
	@Autowired
	private Cat pet4;
	
	@Autowired
	private Cat pet5;
	
	public Human() {
		
	}

	public Human(String name, int age, String[] nickname, ArrayList<String> friend, HashMap<String, Integer> family,
			Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
		this.friend = friend;
		this.family = family;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public ArrayList<String> getFriend() {
		return friend;
	}

	public void setFriend(ArrayList<String> friend) {
		this.friend = friend;
	}

	public HashMap<String, Integer> getFamily() {
		return family;
	}

	public void setFamily(HashMap<String, Integer> family) {
		this.family = family;
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}

	public Cat getPet2() {
		return pet2;
	}
	
	public Cat getPet3() {
		return pet2;
	}
	
	public Cat getPet4() {
		return pet2;
	}
	
	public Cat getPet5() {
		return pet2;
	}

}
