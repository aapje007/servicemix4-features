/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.servicemix.camel;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.apache.servicemix.nmr.api.NMR;
import org.apache.servicemix.nmr.core.ServiceMix;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: gnodet
 * Date: Sep 19, 2007
 * Time: 8:48:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceMixComponent extends DefaultComponent {

    private NMR nmr;
    
    public ServiceMixComponent() {
    	if (nmr == null) {
    		nmr = new ServiceMix();
        	((ServiceMix)nmr).init();
    	}
    }

    public NMR getNmr() {
        return nmr;
    }

    public void setNmr(NMR nmr) {
        this.nmr = nmr;
    }

    protected Endpoint createEndpoint(String uri, String remaining, Map parameters) throws Exception {
        return new ServiceMixEndpoint(this, uri, remaining);
    }

    public void registerEndpoint(org.apache.servicemix.nmr.api.Endpoint endpoint, Map<String, ?> properties) {
        nmr.getEndpointRegistry().register(endpoint, properties);
    }

    public void unregisterEndpoint(org.apache.servicemix.nmr.api.Endpoint endpoint, Map<String, ?> properties) {
        nmr.getEndpointRegistry().unregister(endpoint, properties);
    }
}
