

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class my_system {
	
	/**
	 * 锟斤拷系统锟斤拷锟�
	 * @s(String str) 锟斤拷锟絪tr
	 * @author 锟斤拷
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
	 * 锟斤拷取str锟斤拷num锟斤拷锟斤拷莘锟斤拷锟�
	 * @param str 锟斤拷锟斤拷要锟斤拷锟叫达拷锟斤拷锟斤拷址锟�
	 * @param num 锟斤拷锟斤拷要锟斤拷取锟侥第硷拷锟斤拷锟斤拷锟斤拷
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
	 * 锟皆讹拷锟斤拷锟叫猴拷锟斤拷锟斤拷锟�
	 * @param args 锟斤拷锟斤拷锟斤拷锟皆讹拷锟斤拷锟斤拷锟斤拷锟斤拷隙锟缴碉拷Integer锟斤拷锟斤拷
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
	 * 锟较碉拷锟斤拷锟�
	 * @param str 要锟斤拷锟斤拷锟斤拷址锟�
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
	
	public int search(String strTarget, String strSearch) {
		int result = 0;
		String strCheck = new String(strTarget);
		for (int i = 0; i < strTarget.length();) {
		//System.out.println(i);
		int loc = strCheck.indexOf(strSearch);
		if (loc == -1) {
			break;
			
		//break;
		} else {
		result++;
		i = loc + strSearch.length();
		strCheck = strCheck.substring(i);
		}
		}
		return result;
		}

}
