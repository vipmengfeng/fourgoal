import java.util.ArrayList;

public class start {
	 public static String[] str1 = { "3","2", "1","0"};
	 public static String[] str2 = { "3","2", "1","0"};
	 public static String[] str3 = { "3","2", "1","0"};
	 public static String[] str4 = { "3","2", "1","0"};
	 public static String[] str5 = { "3","2", "1","0"};
	 public static String[] str6 = { "3","2", "1","0"};
	 public static String[] str7 = { "3","2", "1","0"};
	 public static String[] str8 = { "3","2", "1","0" };
	 static ArrayList<String> dataArray = new ArrayList<String> ();
	 static ArrayList<String> dataArrays = new ArrayList<String> ();
	 static String last ="32203322";
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
	
	
	//断点范围5-6
	for(int i=0;i<dataArray.size();i++){
		int dd=ms.dd(dataArray.get(i));
		if(dd<=6&&dd>=5){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	
	
	nums("3",0,2);
	nums("2",1,3);
	nums("1",1,4);
	nums("0",1,3);
	lst();
	int arr[]={2,4,6,8};//奇数列
	int arrs[]={1,5,6};//偶数列
	jiou(arr,1);
	jiou(arrs,0);
	ping(7,8);
	ping(5,6);
	sp(3,4);
	
	
	
	
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
}


private static void result(int r){
	if(r==1){
	for(int i=0;i<dataArray.size();i++){
		ms.s(dataArray.get(i));
	 }
	}
	ms.s("result：");
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
