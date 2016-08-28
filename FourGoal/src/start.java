import java.util.ArrayList;

public class start {
	 public static String[] str1 = { "3","2","1","0"};
	 public static String[] str2 = { "3","2","1","0"};
	 public static String[] str3 = { "3","2","1","0"};
	 public static String[] str4 = { "2","1","0"};
	 public static String[] str5 = { "3","2","1","0"};
	 public static String[] str6 = { "3","2","1","0"};
	 public static String[] str7 = { "3","2","1"};
	 public static String[] str8 = { "3","2","1","0"};
	 static ArrayList<String> dataArray = new ArrayList<String> ();
	 static ArrayList<String> dataArrays = new ArrayList<String> ();
	 static ArrayList<String> datafile = new ArrayList<String> ();
	 static ArrayList<String> datafile2 = new ArrayList<String> ();
	 static String last ="30101301";
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
	datafile=ms.ReadDatas("src/four.txt", datafile);
	datafile2=datafile;
	ms.s(datafile.size());
	//lishi();
	//断点范围5-6
	for(int i=0;i<dataArray.size();i++){
		int dd=ms.dd(dataArray.get(i));
		if(dd<=6&&dd>=5){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	
	//test();
	dipei(2, 1, 3, 4, 5, 6, 7, 8);//最低赔率出现次数最少为1
	nums("3",0,2);
	nums("2",1,2);
	nums("1",1,4);
	nums("0",1,3);
	contains_two();//3210个数中出现两次的数字 范围是1-2
	//test_ji();
	//test_ou();
	//contains(4,5,6,"0","0");//456场包含0
	//contains(6,7,8,"2","3");//678场包含2或3
	lst();//上轮结果相同位置相同数字 个数范围1-3
	//int arr[]={2,8};//包含奇数列
	int arrs[]={1,5,6};//包含偶数列
	//jiou(arr,1);
	jiou(arrs,0);
//	ping(2,3);
//	ping(4,5);
	ping(1,2);//平局排除
	//ping(7,8);
	ping_c(1,2,3,4,5,6,7,8);//包含平局的场次
	//sp(3,4);
	//sp(1,2);//胜平锁定
	//sp(8,7);
	//sp(3,4);
	left_e();//斜向相同数字范围1-4
	last_f();//最近50轮任意三场重复范围2-6
	//lishipc();//历史排除
	
	
	//test_ji();
	
	}
//最低赔率出现次数
private static void dipei(int a,int b,int c,int d,int e,int f,int g,int h){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		int c1=Integer.parseInt(ms.cutNumber(dataArray.get(i), a));
		int c2=Integer.parseInt(ms.cutNumber(dataArray.get(i), b));
		int c3=Integer.parseInt(ms.cutNumber(dataArray.get(i), c));
		int c4=Integer.parseInt(ms.cutNumber(dataArray.get(i), d));
		int c5=Integer.parseInt(ms.cutNumber(dataArray.get(i), e));
		int c6=Integer.parseInt(ms.cutNumber(dataArray.get(i), f));
		int c7=Integer.parseInt(ms.cutNumber(dataArray.get(i), g));
		int c8=Integer.parseInt(ms.cutNumber(dataArray.get(i), h));
		if(c1>c2){
			count++;
		}
		if(c3>c4){
			count++;
		}
		if(c5>c6){
			count++;
		}
		if(c7>c8){
			count++;
		}
		//最低赔出现的个数
		if(count>=2){
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("最低赔率出现次数至少为1");
	result(0);
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
//平局包含
private static void ping_c(int a,int b,int c,int d,int e,int f,int g,int h){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count = 0;
		if(ms.cutNumber(dataArray.get(i), a).equals(ms.cutNumber(dataArray.get(i), b))){
			count++;
		}
		if(ms.cutNumber(dataArray.get(i), c).equals(ms.cutNumber(dataArray.get(i), d))){
			count++;
		}
		if(ms.cutNumber(dataArray.get(i), e).equals(ms.cutNumber(dataArray.get(i), f))){
			count++;
		}
		if(ms.cutNumber(dataArray.get(i), g).equals(ms.cutNumber(dataArray.get(i), h))){
			count++;
		}
		
		if(count>=1){
			
			dataArrays.add(dataArray.get(i));
		}
	}
	put();
	ms.s("对场次进行平局包含排除后：");
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

//斜向相同数字范围2-4
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
		if(count>=1&&count<=4){
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
//3210个数中出现两次的数字 范围是1-2
private static void contains_two(){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		int a=ms.search( dataArray.get(i),"3");
		int b=ms.search( dataArray.get(i),"2");
		int c=ms.search( dataArray.get(i),"1");
		int d=ms.search( dataArray.get(i),"0");
		if(a==2){
			count++;
		}
		if(b==2){
			count++;
		}
		if(c==2){
			count++;
		}
		if(d==2){
			count++;
		}
		if(count>=1&&count<=2){
			dataArrays.add(dataArray.get(i));
			
		}
		
	}
	put();
	ms.s("3210个数2必定出现排除后");
	result(0);
}
//任意三场包含
private  static void contains(int a,int b,int c,String d,String e){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		String a1=ms.cutNumber(dataArray.get(i), a);
		String a2=ms.cutNumber(dataArray.get(i), b);
		String a3=ms.cutNumber(dataArray.get(i), c);
		if(a1.equals(d)||a2.equals(d)||a3.equals(d)){
			dataArrays.add(dataArray.get(i));
		}else if(a1.equals(e)||a2.equals(e)||a3.equals(e)){
			dataArrays.add(dataArray.get(i));
		}
		
	}
	put();
	ms.s("任意三场包含");
	result(0);
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
//与前10轮相比，任意连续三场有相同数字出现的范围是0-1
private static void last_f(){
	dataArrays.clear();
	for(int i=0;i<dataArray.size();i++){
		int count=0;
		
		String str1=dataArray.get(i).substring(0, 3);
		String str2=dataArray.get(i).substring(1, 4);
		String str3=dataArray.get(i).substring(2,5);
		String str4=dataArray.get(i).substring(3,6);
		String str5=dataArray.get(i).substring(4,7);
		//String str6=datafile.get(i).substring(5,7);
		for(int j=0;j<51;j++){
			
			String strs1=datafile.get(j).substring(0,3);
			String strs2=datafile.get(j).substring(1,4);
			String strs3=datafile.get(j).substring(2,5);
			String strs4=datafile.get(j).substring(3,6);
			String strs5=datafile.get(j).substring(4,7);
			
			
			if(str1.equals(strs1)||str2.equals(strs2)||str3.equals(strs3)||str4.equals(strs4)||str5.equals(strs5)){
				count++;
				
			}
		}
		if(count>1&&count<7&&count!=4){
			dataArrays.add(dataArray.get(i));
		}
		
	}
	put();
	ms.s("last_f");
	result(1);
}

//
private static void test(){
	
	for(int i=0;i<datafile.size()-52;i++){
		int count=0;
		//ms.s(datafile.get(i).length());
		String str1=datafile.get(i).substring(0, 3);
		String str2=datafile.get(i).substring(1, 4);
		String str3=datafile.get(i).substring(2,5);
		String str4=datafile.get(i).substring(3,6);
		String str5=datafile.get(i).substring(4,7);
		//String str6=datafile.get(i).substring(5,7);
		for(int j=i+1;j<i+50;j++){
			
			String strs1=datafile.get(j).substring(0,3);
			String strs2=datafile.get(j).substring(1,4);
			String strs3=datafile.get(j).substring(2,5);
			String strs4=datafile.get(j).substring(3,6);
			String strs5=datafile.get(j).substring(4,7);
			
			
			if(str1.equals(strs1)||str2.equals(strs2)||str3.equals(strs3)||str4.equals(strs4)||str5.equals(strs5)){
				count++;
				
			}
		}
		ms.s(datafile.get(i)+"======"+count);
	}
	
}
//奇数列
private static void test_ji(){
	for(int i=0;i<datafile.size()-52;i++){
		if(!datafile.get(i).contains("*")){
		int a1=Integer.parseInt(ms.cutNumber(datafile.get(i),1));
		int a2=Integer.parseInt(ms.cutNumber(datafile.get(i),3));
		int a3=Integer.parseInt(ms.cutNumber(datafile.get(i),5));
		int a4=Integer.parseInt(ms.cutNumber(datafile.get(i),7));
		int b1=Integer.parseInt(ms.cutNumber(datafile.get(i),2));
		int b2=Integer.parseInt(ms.cutNumber(datafile.get(i),4));
		int b3=Integer.parseInt(ms.cutNumber(datafile.get(i),6));
		int b4=Integer.parseInt(ms.cutNumber(datafile.get(i),8));
		
			if (a1%2!=0&&a2%2!=0&&a3%2!=0&&a4%2!=0){
				//奇数列都是奇数
				ms.s(i);
			}else if(b1%2==0&&b2%2==0&&b3%2==0&&b4%2==0){
				//偶数列都是偶数
				ms.s(i);
				
			}
		
		}
	}
	
}

//奇数列
private static void test_ou(){
	dataArrays.clear();
	ms.s(dataArray.size()+".......");
	for(int i=0;i<dataArray.size();i++){
		//if(!datafile.get(i).contains("*")){
		int a1=Integer.parseInt(ms.cutNumber(dataArray.get(i),1));
		int a2=Integer.parseInt(ms.cutNumber(dataArray.get(i),3));
		int a3=Integer.parseInt(ms.cutNumber(dataArray.get(i),5));
		int a4=Integer.parseInt(ms.cutNumber(dataArray.get(i),7));
		int b1=Integer.parseInt(ms.cutNumber(dataArray.get(i),2));
		int b2=Integer.parseInt(ms.cutNumber(dataArray.get(i),4));
		int b3=Integer.parseInt(ms.cutNumber(dataArray.get(i),6));
		int b4=Integer.parseInt(ms.cutNumber(dataArray.get(i),8));
		
			if (a1%2!=0&&a2%2!=0&&a3%2!=0&&a4%2!=0){
				//奇数列都是奇数
				//ms.s(i);
				dataArrays.add(dataArray.get(i));
			}else if(b1%2==0&&b2%2==0&&b3%2==0&&b4%2==0){
				//ms.s(i);
				dataArrays.add(dataArray.get(i));
				
			}else {
				//dataArrays.add(dataArray.get(i));
			}
		
		//}
	}
	put();
	ms.s("奇偶列奇偶排除：");
	result(1);
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
