package com.cosyfish.autosend.service;

import com.cosyfish.autosend.config.OhMyEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

     public Object testEmail() throws Exception {
          OhMyEmail.config(OhMyEmail.SMTP_QQ(false),"","");
          OhMyEmail.subject("这是一封测试TEXT邮件")
                  .from("小姐姐的邮箱")
                  .to("")
                  .text("信件内容")
                  .send();
          return true;
     }
}
