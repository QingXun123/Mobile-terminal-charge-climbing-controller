package com.example.android80;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendTextMail extends Thread{
    private String title;
    private String msuggestions;
    private String toAddress;

    public SendTextMail() {
    }

    public SendTextMail(String toAddress, String title, String msuggestions) {
        this.title = title;
        this.msuggestions = msuggestions;
        this.toAddress = toAddress;
    }

    public void run() {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.qq.com");//smtp地址
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("3049625601@qq.com");// 发送方邮件地址
        mailInfo.setPassword("lcbygiydbggcdebh");// 邮箱POP3/SMTP服务授权码
        mailInfo.setFromAddress("3049625601@qq.com");// 发送方邮件地址
        mailInfo.setToAddress(toAddress);//接受方邮件地址
        mailInfo.setSubject(title);//设置邮箱标题
        mailInfo.setContent(msuggestions);
        // 判断是否需要身份认证
        MailAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        Log.d(TAG, "autoSendMail: msuggestions: " + msuggestions);
    }
}
