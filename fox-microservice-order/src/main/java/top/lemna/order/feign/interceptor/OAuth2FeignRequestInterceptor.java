package top.lemna.order.feign.interceptor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

  private static final String AUTHORIZATION_HEADER = "Authorization";

  private static final String BEARER_TOKEN_TYPE = "Bearer";


  @Override
  public void apply(RequestTemplate template) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Object details = authentication.getDetails();

    String token = null;
    if (details != null && details instanceof OAuth2AuthenticationDetails) {
      OAuth2AuthenticationDetails oauth2Details = (OAuth2AuthenticationDetails) details;
      token = oauth2Details.getTokenValue();
    }
    if (template.headers().containsKey(AUTHORIZATION_HEADER)) {
      log.warn("The Authorization token has been already set");
    } else {
      log.debug("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
      template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, token));
    }
  }
}
