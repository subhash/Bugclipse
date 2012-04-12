package com.bugclipse.fogbugz.api.launch;

import java.io.FileReader;

import org.exolab.castor.builder.SourceGenerator;
import org.exolab.castor.builder.SourceGeneratorMain;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.schema.util.XMLInstance2Schema;

import com.bugclipse.fogbugz.api.Response;

public class LauncherMain {

	public static void main(String[] args) throws Exception {
		//XMLInstance2Schema.main(new String[]{"data/payload.xml"});
		//SourceGeneratorMain.main(new String[]{"-i","data/fogbugz-api.xsd","-package","com.bugclipse.fogbugz.api","-binding-file","data/srcgen-binding.xml"});
		Unmarshaller un = new Unmarshaller(Response.class);
		Object o = un.unmarshal(new FileReader("data/payload2.xml"));
		if (o instanceof Response) {
			Response r = (Response) o;
			System.out.println("email - "+r.getCases().getCase().getSCustomerEmail());
			System.out.println("event desc - "+r.getEvents().getEvent().getEvtDescription());
			System.out.println("post - "+r.getTopic().getPost()[0].getSPost());
		}
	}

}