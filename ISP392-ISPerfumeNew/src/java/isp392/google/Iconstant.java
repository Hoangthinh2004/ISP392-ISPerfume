/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.google;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author duyhc
 */
class Iconstant {
      private static final Dotenv dotenv = Dotenv.configure().directory("").load();
      public static final String GOOGLE_CLIENT_ID = dotenv.get("");
      public static final String GOOGLE_CLIENT_SECRET = dotenv.get("");
      public static final String GOOGLE_REDIRECT_URI = dotenv.get("");
      public static final String GOOGLE_GRANT_TYPE = dotenv.get("");
      public static final String GOOGLE_LINK_GET_TOKEN = dotenv.get("");
      public static final String GOOGLE_LINK_GET_USER_INFO = dotenv.get("");
}
