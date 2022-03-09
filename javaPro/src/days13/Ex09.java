package days13;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 7. - 오후 3:41:24
 * @subject [로또 예제] days09.Ex04_02
 * @content 
 */
public class Ex09 {

	   public static void main(String[] args) {
		      
		      //  1. 게임 회수 입력 ? 3
		      /*
		       *  1 로또번호 :  [34][1][7][13][10][44]
		       *  2 로또번호 : [34][1][7][13][10][44]
		       *  3 로또번호 : [34][1][7][13][10][44]
		       *  
		       *  ----> 1차원 배열  int []   lotto = new int[6*게임회수]  
		       *  ----> 2차원 배열  int [][] lotto = new int[게임횟수][6];
		       *  
		       *  4:00 쉬는 시간  + 15분 정도 문제 풀기  X  
		       *  4:15 풀이
		       */
		      
		      // 동적 배열
		      int [][] lottos ; // 배열 선언
		      int gameNumber = 1;
		      Scanner scanner = new Scanner(System.in);      
		      System.out.print("> 게임 회수 입력 ? ");
		      gameNumber = scanner.nextInt();      
		      lottos = new int[gameNumber][6];      
		      fillLottos( lottos );
		       dipsLottos( lottos );      
		   } // main

		   private static void dipsLottos(int[][] lottos) {
		       for (int i = 0; i < lottos.length; i++) {
		         System.out.printf("%d 로또번호 : " , (i+1)); 
		         for (int j = 0; j < lottos[i].length; j++) {
		            System.out.printf(" [%d]", lottos[i][j]);
		         }
		         System.out.println(); // 개행
		      }      
		   }

		   public static boolean isDuplicateLotto(int [][] lottos, int row, int idx, int temp) {
		      boolean flag = false;
		      for (int i = 0; i < idx; i++) {
		         if( temp == lottos[row][i]) {
		            flag = true;
		            break;
		         }
		      }
		      return flag;
		   }
		   
		   private static void fillLottos(int[][] lottos) {
		       int gameNumber =   lottos.length ; // 행 갯수 == 게임횟수
		       for (int i = 0; i < lottos.length; i++) { // 게임 횟수 
		          // 로또 0 0 0 0 0 0   for X
		          Random  rnd = new Random();      
		           int idx = 0;      
		          while(  idx <= 5 ) { 
		               int temp = rnd.nextInt(45) + 1;  
		               //System.out.println(temp);
		               if( !isDuplicateLotto(lottos, i,  idx, temp)   ) {
		                  lottos[i][idx++] = temp;
		               } 
		           } // while 
		          
		      } // for i
		   }
		 
		} // class

