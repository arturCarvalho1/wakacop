package academy.Wakadanda.wakacop.sessaovotacao.infra;

import academy.Wakadanda.wakacop.config.AwsConfigProperties;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.ResultadoSessaoResponse;
import academy.Wakadanda.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoIfraSNS implements PublicadorResultadoSessao {
    private final NotificationMessagingTemplate publicadorResultadoSNS;
    private final AwsConfigProperties awsSnsProperties;

    @Override
    public void publica(ResultadoSessaoResponse resultadoSessaoResponse) {
       log.debug("[start] PublicadorResultadoSessaoIfraSNS - publica");
       publicadorResultadoSNS.sendNotification(awsSnsProperties,resultadoSessaoResponse.getIdPauta().toString());
       log.debug("[finish] PublicadorResultadoSessaoIfraSNS - publica");
    }
}
