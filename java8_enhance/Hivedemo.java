package com.tookerski.hivedemo;

import org.apache.hadoop.hive.service.HiveServerException;
import org.apache.hadoop.hive.service.ThriftHive;
import org.apache.hadoop.hive.service.ThriftHive.Client;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;

public class Hivedemo {
	static TSocket transport;
	//����getClient��������һ��jdbc����
	private static Client getClient(String hiveServer,Integer hivePort){
		final int SOME_BIG_NUMBER = 99999999;
		Client client = null;
		try {
			transport = new TSocket(hiveServer, hivePort);
			transport.setTimeout(SOME_BIG_NUMBER);
			transport.open();
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			client = new ThriftHive.Client(protocol);
			System.out.println("Connection is established");
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//�������ݿ�ķ���
	private Client create_dbs(Client c1,String db_name){
		try {
			c1.execute("CREATE DATABASE "+db_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����jdbc_demo��");
		System.out.println("---------------");
		return c1;
	}
	//�����л����ݿ�ķ���
	private Client use_dbs(Client c1,String db_name){
		try {
			c1.execute("USE "+db_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�л����ݿ�");
		System.out.println("---------------");
		return c1;
	}
	//������
	private Client create_tables(Client c1){
		try {
			c1.execute("CREATE TABLE sample_data(first_name string,last_name string) STORED AS TEXTFILE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����sample_data��");
		System.out.println("---------------");
		Client c2 = c1;
		return c2;
	}
	private Client load_data(Client c1,String tb1_name){
		try {
			c1.execute("LOAD DATA LOCAL INPATH '/home/tookerski/Downloads/sample.txt' INTO TABLE "+tb1_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�������� "+tb1_name);
		System.out.println("---------------");
		Client c2 = c1;
		return c2;
	}
	public static void main(String[] args) {
		String HIVE_SERVER = "192.168.1.111";
		Integer HIVE_PORT = new Integer(10000);
		Client client = getClient(HIVE_SERVER, HIVE_PORT);
		Hivedemo hd = new Hivedemo();
		String db_name = "jdbc_demo";
		client = hd.create_dbs(client, db_name);
		client = hd.use_dbs(client, db_name);
		client = hd.create_tables(client);
		client = hd.load_data(client, "sample_data");
		transport.close();
	}

}
