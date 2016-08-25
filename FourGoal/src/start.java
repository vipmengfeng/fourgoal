import java.util.ArrayList;

public class start {
	 public static String[] str1 = { "3","2", "1"};
	 public static String[] str2 = { "3","2", "1"};
	 public static String[] str3 = { "3","2", "1"};
	 public static String[] str4 = { "3","2", "1","0"};
	 public static String[] str5 = { "2", "1","0"};
	 public static String[] str6 = { "2", "1","0"};
	 public static String[] str7 = { "3","2", "1"};
	 public static String[] str8 = { "2", "1","0" };
	 static ArrayList<String> dataArray = new ArrayList<String> ();
	 static ArrayList<String> dataArrays = new ArrayList<String> ();
	 static ArrayList<String> datafile = new ArrayList<String> ();
	 static ArrayList<String> datafile2 = new ArrayList<String> ();
	 static String last ="10033110";
	 static my_system ms= new my_system();
public static void main(String[] args){
	
	dikaerji dk= new dikaerji();
	dk.str1=str1;
	dk.str2=str2;
	dk.str3=str3;
	dk.str4=str4;
	dk.str5=str5;
	dk.str6=str6;
	dk.str7=str7;
	dk.str8=str8;
	dk.dikaerjistart(dataArray);
	ms.s("原始条数：");
	ms.s(dataArray.size());
	datafile.clear();
	datafile2.clear();
	datafile=ms.ReadDatas("/Users/meng/Documents/fourgoal/FourGoal/src/four.txt", datafile);
	datafile2=datafile;
	ms.s(datafile.size());
	lishi();
	//断点范围5-6
	for(int i=0;i<dataArray.size();i++){
		int dd=ms.dd(dataArray.get(i));
		if(dd<=6&&dd>=5){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	
	
	nums("3",1,2);
	nums("2",1,3);
	nums("1",1,4);
	nums("0",1,3);
	lst();
	int arr[]={2,4,6,8};//奇数列
	int arrs[]={1,5,6};//偶数列
	//jiou(arr,1);
	//jiou(arrs,0);
	ping(2,3);
	
	ping(7,8);
	//ping(5,6);
	san("123","101");
	san("123","031");
	san("123","010");
	san("123","121");
	san("678","110");
	san("345","120");
	san("345","130");
	san("345","101");
	san("678","131");
	san("456","002");
	san("456","011");
	sp(3,4);
	sp(1,2);
	sp(7,8);
	left_e();
	lishipc();
	
	
	
	}
//3210的个数范围
private static void nums(String n,int s,int e){
	
	dataArrays.clear();
		for(int i=0;i<dataArray.size();i++){
			int dd=ms.getSubCount(dataArray.get(i),n);
			if(dd<=e&&dd>=s){
				dataArrays.add(dataArray.get(i));
			}
		}
		put();
		ms.s("3210个数范围锁定后");
		result(0);
}
//上轮结果相同位置相同数字 个数范围1-3
private static void lst(){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		for(int j=1;j<9;j++){
			if(ms.cutNumber(dataArray.get(i), j).equals(ms.cutNumber(last, j))){
				count++;
			}
			
		}
		if(count>=1&&count<=3){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("上轮结果相同位置相同数字 个数范围1-3：");
	result(0);
}
//列奇偶判断 f 为1时 判断奇数，f为其他时 判断偶数
private static void jiou(int arr[],int f){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		for (int x : arr){
			int js=Integer.parseInt(ms.cutNumber(dataArray.get(i), x));
			if(f==1){
				if(js%2!=0){
					count++;
				}
			}else{
				if(js%2==0){
					count++;
				}
			}
		}
		if(count>=1){
			dataArrays.add(dataArray.get(i));
		}
	}
	
	put();
	ms.s("对列进行奇偶设定筛选后：");
	result(0);
}
//平局排除
private static void ping(int a,int b){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		if(!ms.cutNumber(dataArray.get(i), a).equals(ms.cutNumber(dataArray.get(i), b))){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("对单独场次进行平局排除后：");
	result(0);
}
//胜平
private static void sp(int a,int b){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int js=Integer.parseInt(ms.cutNumber(dataArray.get(i), a));
		int js2=Integer.parseInt(ms.cutNumber(dataArray.get(i), b));
		if(js>=js2){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("对单独场次进行31筛选后：");
	result(0);
}
//任意三场连续排除
private static void san(String a,String b){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int a1=Integer.parseInt(a.substring(0, 1));
		int a2=Integer.parseInt(a.substring(1, 2));
		int a3=Integer.parseInt(a.substring(2, 3));
		String b1=b.substring(0, 1);
		String b2=b.substring(1, 2);
		String b3=b.substring(2, 3);
		String c1=ms.cutNumber(dataArray.get(i), a1);
		String c2=ms.cutNumber(dataArray.get(i), a2);
		String c3=ms.cutNumber(dataArray.get(i), a3);
		if(c1.equals(b1)&&c2.equals(b2)&&c3.equals(b3)){
			
			
		}else{
			dataArrays.add(dataArray.get(i));
		}
		
		
	}
	put();
	ms.s(a+"场次不为："+b);
	result(0);
}

//斜向相同数字范围1-3
private static void left_e(){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		for(int j=1;j<8;j++){
			if(ms.cutNumber(dataArray.get(i),j).equals(ms.cutNumber(last, j+1))){
				count++;
			}
			
		}
		for(int j=2;j<9;j++){
			if(ms.cutNumber(dataArray.get(i),j).equals(ms.cutNumber(last, j-1))){
				count++;
			}
		}
		if(count>=1&&count<=3){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("斜向排除");
	result(0);
}
//历史数据排除
private static void lishipc(){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		if(datafile.indexOf(dataArray.get(i))==-1){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("历史排除后");
	result(1);
}
private static void lishi(){
	for(int i=0;i<datafile.size()-1;i++){
		for(int j=i+1;j<datafile2.size();j++){
			if(datafile.get(i).equals(datafile2.get(j))){
				
				ms.s(i+"===="+j+"::"+datafile.get(i));
				
			}
			
		}
		
	}
	
}

private static void result(int r){
	if(r==1){
	for(int i=0;i<dataArray.size();i++){
		ms.s(dataArray.get(i));
	 }
	ms.s("result：");
	}
	
	ms.s(dataArray.size());
}
// 重新将过滤后的结果赋值给dataArray
private static void put(){
	
	dataArray.clear();
	for(int i=0;i<dataArrays.size();i++){
		dataArray.add(dataArrays.get(i));
	}
	
}
}
