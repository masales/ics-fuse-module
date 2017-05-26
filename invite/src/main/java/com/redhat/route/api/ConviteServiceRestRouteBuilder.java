package com.redhat.route.api;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.core.MediaType;

import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

import com.redhat.dto.InviteResponse;
import com.redhat.jaxb.Convite;
import com.redhat.route.plubing.AbstractRouteBuilder;

@Component
public class ConviteServiceRestRouteBuilder extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	rest("/convite")
	.description("API de serviços para convite").consumes(MediaType.APPLICATION_JSON)
		.produces(MediaType.APPLICATION_JSON)
		// post - criar convite
		.post().description("Enviar novo convite").type(Convite.class).param().name("body").type(RestParamType.body)
		.description("Convite a ser enviado").endParam().responseMessage().code(CREATED.getStatusCode())
		.message("Convite criado e enviado a todos os participantes").responseModel(InviteResponse.class).endResponseMessage()
		.to("direct:criarConviteRoute")
		// put - atualizar convite
		.put().description("Atualizar convite").type(Convite.class).param().name("body").type(RestParamType.body)
		.description("Convite a ser alterado").endParam().responseMessage().code(OK.getStatusCode())
		.message("Convite atualizado e enviado a todos os participantes").endResponseMessage().to("direct:atualizarConviteRoute")
		// delete - cancelar convite
		.delete().description("Cancelar convite").type(Convite.class).param().name("body").type(RestParamType.body)
		.description("Convite a ser cancelado").endParam().responseMessage().code(OK.getStatusCode())
		.message("Convite cancelado e notificado aos participantes").endResponseMessage().to("direct:cancelarConviteRoute")
		// get - heath
		.get().description("Monitora a saúde do serviço").responseMessage().code(OK.getStatusCode())
		.message("Serviço funcionando").endResponseMessage().to("direct:pingConviteRoute")
		;

    }

}
