package com.utility;

import java.sql.Connection;

public class establish {

	public static void main(String[] args) {

		Connection conn= DBUtility.establishConnection();
		
		
		System.out.println(conn);

	}

}
