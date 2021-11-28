import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    /**
     * 发送邮件
     * @param FromEmail 发送邮件的邮箱
     * @param ToEmail 接收邮件的邮箱
     * @param subject 邮件的主题
     * @param message 邮件的正文
     */
    public static void sendEmail(String FromEmail,String ToEmail,
                                 String subject,String message) {
        SimpleEmail email = new SimpleEmail();
        email.setSslSmtpPort("465");
        email.setHostName("smtp.qq.com");
        email.setAuthentication(FromEmail, "pykkmyniimpdhfid");
        email.setCharset("UTF-8");
        try {
            email.addTo(ToEmail);
            email.setFrom(FromEmail);
            email.setSubject(subject);
            email.setMsg(message);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        //qq：qq邮件服务器的端口号
        email.setSslSmtpPort("465");
        //
        email.setHostName("smtp.qq.com");
        //
        email.setAuthentication("你的邮箱@qq.com", "你的码");
        email.setCharset("UTF-8");
        //1、从文件把所有的qq邮箱读取出来
        //2、存储到一个数据结构当中
        //3、String email = 数据结构当中取一个
        try {
            email.addTo("你要发的邮箱@qq.com");
            //email.addTo("1262913815@qq.com");
            email.setFrom("你的邮箱@qq.com");
            email.setSubject("小比特");
            email.setMsg("----Hello!!!----");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
