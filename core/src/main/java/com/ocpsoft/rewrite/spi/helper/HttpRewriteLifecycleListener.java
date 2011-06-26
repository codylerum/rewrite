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
package com.ocpsoft.rewrite.spi.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocpsoft.rewrite.RewriteEvent;
import com.ocpsoft.rewrite.inbound.HttpRewriteEvent;
import com.ocpsoft.rewrite.spi.RewriteLifecycleListener;

/**
 * A {@link RewriteLifecycleListener} that only listens on {@link HttpServletRequest} and {@link HttpServletResponse}
 * request cycle types.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public abstract class HttpRewriteLifecycleListener implements RewriteLifecycleListener<HttpRewriteEvent>
{
   @Override
   public boolean handles(final RewriteEvent<?, ?> event)
   {
      return event instanceof HttpRewriteEvent;
   }
}