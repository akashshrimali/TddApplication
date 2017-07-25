package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TddApplication.class })
public class TddApplicationTests {
	int storageStructure[] = new int[100000];
	int time[] = new int[100000];
	int n = storageStructure.length;

	@Autowired
	private TddApplication testResult;

	@Before
	public void setup() {
	}

	@Test
	public void exampleTest() {
		
		int result = testResult.solve(100, generateOneRowCase(), generateOneRowCase(), 3);
		assertThat(result);
	
	}
	public int[] generateOneRowCase()
	{
		int[] A = {7988,82328,78841};
		return  A;
	}
	public int[] generateTwoRowCase()
	{
		int[] B = {504,730,613};
		return B;
	};
}