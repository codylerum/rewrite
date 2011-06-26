/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.cdi;

import javax.enterprise.context.spi.CreationalContext;

import org.jboss.logging.Logger;
import org.jboss.seam.solder.beanManager.BeanManagerAware;

import com.ocpsoft.rewrite.spi.ServiceEnricher;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class CdiServiceEnricher extends BeanManagerAware implements ServiceEnricher
{
   Logger log = Logger.getLogger(CdiServiceEnricher.class);

   @Override
   public <T> T produce(final Class<T> type)
   {
      T instance = BeanManagerUtils.getContextualInstance(getBeanManager(), type);
      if (instance != null)
      {
         log.debug("Created CDI enriched service [" + type.getName() + "]");
      }
      return instance;
   }

   @Override
   public <T> T enrich(final T service)
   {
      CreationalContext<Object> context = BeanManagerUtils.injectNonContextualInstance(getBeanManager(), service);
      if (context != null)
      {
         log.debug("Enriched non-contextual intance of service [" + service.getClass().getName() + "]");
      }
      return service;
   }

}