import java.util.ArrayList;
import java.util.Scanner;

public class App {	
    public static void main(String args[]){
        String menu;
        ArrayList<todoList> todoArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
      
        boolean onceQuestion = false;
        
        while (true) { 
            System.out.println("ToDo 리스트");
            System.out.println("1.할 일 추가");
            System.out.println("2.완료된 항목 체크");
            System.out.println("3.목록 보기");
            System.out.println("4.할일 수정");
            System.out.println("5.할일 삭제");
            System.out.println("6.종료");
            
            int num=sc.nextInt();
            switch(num){
                case 1:
                	while(true) {
	                    System.out.print("할일을 입력하시겠습니까? (o or x를 누르세요)");
	                    String tf1=sc.next();
	                    if(tf1.equals("x")){
	                        break;
	                    }
	                    else if(tf1.equals("o")){
	                        while (true){
	                            System.out.print("할 일을 입력하세요: ");
                            	String todo = sc.next();
	                            todoArrayList.add(new todoList(todo, false));                                
	                            System.out.println("할 일이 추가되었습니다. (계속은 'o', 아니면 'x')");
	                            if(sc.next().equals("x")) break;
	                            else continue;
	                        }
	                    } else {
	                    	System.out.println("다시 입력해주세요.");
	                    	continue;
	                    }
                	}
                    break;
                case 2:
                    for(int i=0; i<todoArrayList.size(); i++){
                        if(todoArrayList.get(i).isCheck() == false){
                            System.out.print((i+1)+"번 "+todoArrayList.get(i).getTodoName()+",미완료\n");
                        }
                    }
                	
	                while(true) {
                    int countTrue = 0;
	                	for(int i=0; i<todoArrayList.size(); i++) {
                      	if(todoArrayList.get(i).isCheck() == true){
                          	countTrue+=1;
                        }
                    }
                  
	                	int listSize = todoArrayList.size();
	                	
	                	if(countTrue == listSize) {
	                		System.out.println("모든 항목을 완료하셨습니다.");
	                		break;
	                	}
	                	
	                	if(onceQuestion == false) {
	                		System.out.print("항목을 완료하시겠습니까? (o or x를 누르세요)");
	                	} else if(onceQuestion == true) {
	                		System.out.print("다른 항목도 완료하시겠습니까? (o or x를 누르세요)");
	                	}
	                  
	                    String tf2=sc.next();
	                    if(tf2.equals("x")){
	                        break;
	                    }
	                    else if(tf2.equals("o")){
	                        System.out.print("어떤 항목을 완료하시겠습니까?");
	
	                        int a=sc.nextInt();
	                        todoArrayList.get(a-1).setCheck(true);
                        
	                        for(int i=0; i<todoArrayList.size(); i++){
	                            System.out.println((i+1)+"번 "+todoArrayList.get(i).getTodoName() + "," + (todoArrayList.get(i).isCheck() ? "완료":"미완료"));
	                        }
	                        
	                        onceQuestion = true;
	                        
	                    } else {
	                    	System.out.println("다시 입력해주세요.");
	                    	continue;
	                    }
                	}
                    break;
                case 3:
                    System.out.println("목록");
                    for(int i=0; i<todoArrayList.size(); i++){
                            System.out.print((i+1)+"번 "+todoArrayList.get(i).getTodoName()+(todoArrayList.get(i).isCheck() ? "완료\n" : "미완료\n"));
                    }

                    break;
                case 4:
                    System.out.println("어떤 일을 수정하시겠습니까?\n번호를 입력해 주세요.");
                    int editnum=sc.nextInt();
                    if(editnum<=todoArrayList.size() && editnum>0){
                        System.out.println("새로운 할 일을 입력해 주세요.");
                        String newTodo = sc.next();
                        todoArrayList.get(editnum - 1).setTodoName(newTodo);
                    }
                    else{
                        System.out.println("다시 입력해 주세요.");
                    }
                    break;
                case 5:
                    System.out.print("삭제할 항목의 번호를 입력하세요: ");
                    int deleteNumber = sc.nextInt();
                    if (deleteNumber > 0 && deleteNumber <= todoArrayList.size()) {
                        todoArrayList.remove(deleteNumber - 1);
                        System.out.println("항목이 삭제되었습니다.");
                    } else {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;
                case 6: 
                    sc.close();
                    return;
            }
        }
    }
}

class todoList {
    String todoName;
    boolean check;

    public todoList(String todoName, boolean check) {
      this.todoName = todoName;
      this.check = check;
    }

    public String getTodoName() {
      return todoName;
    }

    public void setTodoName(String todoName) {
      this.todoName = todoName;
    }

    public boolean isCheck() {
      return check;
    }

    public void setCheck(boolean check) {
      this.check = check;
    }
} 