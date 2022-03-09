package interviewqns;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TestApp {
    protected int x, y;
}

public class InterviewQuestions {
	
	int i[] = { 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestApp app = new TestApp();
		System.out.println(app.x+app.y);
		
		
		int i[] = { 1 };
        alter(i);
        System.out.println(i[0]);
	}
	
	public static void alter(int i[]) {
        int j[] = { 2 };
        i = j;
    }
	

	
	private void CheckLoop()
	{
		for (int index = 0; 1; index++) {
            System.out.println("Welcome");
            break;
        }
	}
	
	private void LoopPrint() {
		for (int index = 0; true; index++) {
            System.out.println("Welcome");
            break;
        }
	}
	
	
	//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // E.g Input: nums = [2,7,11,15], target = 9
	// Output: [0,1]

	private int[] twoSum(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int i = 0;i<nums.length;i++) {
			int curVal = nums[i];
			int x= target-curVal;
			
			if(map.containsKey(x)) {
				return new int[] {i,map.get(x)};
			}
			
			map.put(curVal,i);
		}
		return null;
	}
	
	//Given a string paragraph and a string array of the banned words banned, 
	//return the most frequent word that is not banned. It is guaranteed there is at 
	// least one word that is not banned, and that the answer is unique.
    //Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
	//Output: "ball"

	
	private String mostCommonWord(String input, String[] banned) {
		
		String normalizedStr = input.replaceAll("[^a-zA-Z0-9", " ");
		
		String[] words = normalizedStr.split("\\s+");
		
		Set<String> bannedWords = new HashSet<>();
		
		for(String word: banned) {
			bannedWords.add(word);
		}
		
		Map<String,Integer> wordCount = new HashMap<>();
		
		for(String word:words) {
			if(!bannedWords.contains(word)) {
				wordCount.put(word, wordCount.getOrDefault(word,0)+1);
			}
		}
		
		return Collections.max(wordCount.entrySet(),Map.Entry.comparingByValue()).getKey();
		
	}
	
	
	/*You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

	There are two types of logs:

	Letter-logs: All words (except the identifier) consist of lowercase English letters.
	Digit-logs: All words (except the identifier) consist of digits.
	Reorder these logs so that:

	The letter-logs come before all digit-logs.
	The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
	The digit-logs maintain their relative ordering.
	Return the final order of the logs.*/
	
	/*Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]*/
	
	
	private String[] reOrderLogs(String[] logs) {
		
		Comparator<String> myComp = new Comparator<String>() {

			@Override
			public int compare(String log1, String log2) {
				// TODO Auto-generated method stub
				String[] split1 = log1.split("",2);
				String[] split2 = log2.split("",2);
				
				boolean isDigit1 =  Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
				
				if (!isDigit1 && !isDigit2) {
					
					int cmp = split1[1].compareTo(split2[1]);
					
					if (cmp!=0)
						return cmp;
					
					return split1[0].compareTo(split2[0]);
				}
				
				if(!isDigit1 && isDigit2) 
				    return -1;
				
				if(isDigit1 && !isDigit2)
					return 1;
				else
					return 0;
				
			}
		};
		
		Arrays.sort(logs,myComp);
		
		return logs;
	}
}
		
	   
	
	




