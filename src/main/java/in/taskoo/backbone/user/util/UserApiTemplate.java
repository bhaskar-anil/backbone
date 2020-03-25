package in.taskoo.backbone.user.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.taskoo.common.util.CommonApiTemplate;

@Component("userApiTemplate")
public class UserApiTemplate extends CommonApiTemplate {
  @Value("${message.api.proxy.schme}")
  private String proxySchme;

  @Value("${message.api.proxy.hostname}")
  private String proxyHost;

  @Value("${message.api.proxy.port}")
  private String proxyPort;

  @Value("${message.api.connect.timeout}")
  private String connectTimeout;

  @Value("${message.api.read.timeout}")
  private String readTimeout;
}
