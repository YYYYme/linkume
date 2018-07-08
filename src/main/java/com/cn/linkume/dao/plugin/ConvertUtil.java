package com.cn.linkume.dao.plugin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class ConvertUtil {
	/**
	 * Blob转String
	 * 
	 * @param blob
	 * @return
	 */
	public static String convertBlobToString(Blob blob) {
		String result = "";
		try {
			ByteArrayInputStream msgContent = (ByteArrayInputStream) blob
					.getBinaryStream();
			byte[] byte_data = new byte[msgContent.available()];
			msgContent.read(byte_data, 0, byte_data.length);
			result = new String(byte_data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * String装Blob
	 * @param str
	 * @return
	 */
	public static Blob convertStringToBlob(String str) {
		Blob b = null;
		try {
			b = new SerialBlob(str.getBytes("UTF8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * String转byte
	 * @param str
	 * @return
	 */
	public static byte[] convertStringToByte(String str){
		if (str == null) {
	        return null;
	    }
	    byte[] byteArray = str.getBytes();
	    return byteArray;
	}
	
	/**
     * 将对象转化为字节数组
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] objectToBytes(Object object) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        byte[] bytes = baos.toByteArray();
        baos.close();
        oos.close();
        return bytes;
    }
    
    /**
     * 将字节数组转化为对象
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static  <T> T bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object object = ois.readObject();
        bais.close();
        ois.close();
        return (T) object;
    }
}
