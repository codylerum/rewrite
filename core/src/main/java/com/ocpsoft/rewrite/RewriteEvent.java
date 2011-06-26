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
package com.ocpsoft.rewrite;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ocpsoft.rewrite.BaseRewriteEvent.Flow;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface RewriteEvent<IN extends ServletRequest, OUT extends ServletResponse>
{
   /**
    * Get the current {@link ServletRequest}.
    */
   public IN getRequest();

   /**
    * Get the current {@link ServletResponse}.
    */
   public OUT getResponse();

   /**
    * Get the current {@link Flow} state.
    */
   public Flow getFlow();

   /**
    * Returns the resource address of the requested {@link MutableRewriteEvent#include(String)} or
    * {@link MutableRewriteEvent#forward(String)}
    */
   public String getDispatchResource();
}