

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class my_system {
	
	/**
	 * ��ϵͳ���
	 * @s(String str) ���str
	 * @author ��
	 * @since 2015.5.17
	 */
	public void s(String str){
		
		System.out.println(str);
		
	}
public void s(float str){
		
		System.out.println(str);
		
	}
	public void s(int str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}
	public Integer[] strArray2intArray(String[] arr){
        Integer[] intArr = new Integer[arr.length];
        for (int i=0; i<arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }
	
	public  boolean comi(String str,int num,String value)
	 {
		 if(str.substring(num-1, num).equals(value))
		 {
			 return true;
		 }else{
			 return false;
		 }
	 }
	/**
	 * ��ȡstr��num����ݷ���
	 * @param str ����Ҫ���д�����ַ�
	 * @param num ����Ҫ��ȡ�ĵڼ�������
	 * @return
	 */
	public String cutNumber(String str,int num)
	{
		String Resturnstr=str.substring(num-1,num);
		return Resturnstr;
	}
	public int getSubCount(String str,String key){
	    int count = 0;
	    int index = -1;
	    while ((index=str.indexOf(key,index))>-1){
	        ++index;
	        ++count;
	    }
	    return count;
	}
	
	/**
	 * �Զ����к������
	 * @param args �������Զ���������϶�ɵ�Integer����
	 */
	public ArrayList<String> CustomResult(Integer[] args,ArrayList<String> AL)
	{
		String customstr="";
		ArrayList<String> customArray = new ArrayList<String> ();
		customArray.clear();
		
		for(int j=0;j<AL.size();j++)
		{
			customstr="";
			for(int i=0;i<args.length;i++)
			{
				customstr+=AL.get(j).substring((args[i]-1), args[i]);
			}
			
			customArray.add(customstr);
		}
		
		return customArray;
		
		
	}
	/**
	 * �ϵ����
	 * @param str Ҫ������ַ�
	 */
	public int dd(String str)
	{
		int customresultNum=str.length();
		int samenumber=0;
		for(int j=1;j<customresultNum;j++)
		{
			if(!cutNumber(str, j).equals(cutNumber(str, j+1)))
			{
				samenumber++;
			}
		}
		return samenumber;
		
	}

	public ArrayList<String> ReadDatas(String src,ArrayList<String> dataArray)
	{
		dataArray.clear();
		
		try
        {
         File f2=new File(src); 
        
         BufferedReader bfr2=new BufferedReader(new FileReader(f2));
         String str2=bfr2.readLine();
        
         while(str2!=null)
            {
        	 	dataArray.add(str2);
            	str2 = bfr2.readLine();
            }
         bfr2.close(); 
        }catch(IOException f2){
        	s("dd");
        }
		return dataArray;
	}

}
