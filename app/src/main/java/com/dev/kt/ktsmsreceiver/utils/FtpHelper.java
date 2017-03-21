package com.dev.kt.ktsmsreceiver.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;


/**
 * Created by Андрей on 13.03.2017.
 */

public class FtpHelper {


    public static void storeFile(final String file_name, final String file_local_path) {

        Thread thread = new Thread(() -> {
            try {
                FTPClient con = new FTPClient();
                con.connect(InetAddress.getByName(StoragePref.getHostName()));

                if (con.login(StoragePref.getLogin(), StoragePref.getPassword())) {
                    con.setFileType(FTP.BINARY_FILE_TYPE);

                    String data = file_local_path + file_name;

                    FileInputStream in = new FileInputStream(new File(data));

                    con.storeFile(StoragePref.getPath() + file_name, in);
                    in.close();
                    con.logout();
                    con.disconnect();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
