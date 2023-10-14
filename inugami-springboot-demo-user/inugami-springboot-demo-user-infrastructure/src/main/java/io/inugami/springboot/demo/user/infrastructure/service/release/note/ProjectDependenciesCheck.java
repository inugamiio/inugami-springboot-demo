/* --------------------------------------------------------------------
 *  Inugami
 * --------------------------------------------------------------------
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package io.inugami.springboot.demo.user.infrastructure.service.release.note;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.inugami.api.exceptions.UncheckedException;
import io.inugami.api.marshalling.JsonMarshaller;
import io.inugami.maven.plugin.analysis.front.api.models.DependenciesCheck;
import io.inugami.maven.plugin.analysis.front.api.services.DependenciesCheckService;

public class ProjectDependenciesCheck implements DependenciesCheckService {
    private static final String DATA = """
            {
              "ban" : [ {
                "comment" : "CVE-2021-44832 : Log4j2 contains major security issue",
                "groupId" : "org.apache.logging.log4j",
                "level" : "critical",
                "link" : "https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-4483",
                "rules" : {
                  "major" : {
                    "ruleType" : "=",
                    "version" : 2
                  },
                  "minor" : {
                    "ruleType" : "<",
                    "version" : 17
                  }
                }
              } ],
              "deprecated" : [ {
                "comment" : "Please update to inugami maven plugin version 1.5.2 or higher",
                "groupId" : "io.inugami.maven.plugin.analysis",
                "link" : "https://search.maven.org/artifact/io.inugami.maven.plugin.analysis/inugami-project-analysis-maven-plugin-parent/1.5.2/pom",
                "rules" : {
                  "major" : {
                    "ruleType" : "=",
                    "version" : 1
                  },
                  "minor" : {
                    "ruleType" : "<",
                    "version" : 5
                  }
                }
              }, {
                "groupId" : "org.apache.logging.log4j",
                "link" : "https://search.maven.org/search?q=g:org.apache.logging.log4j",
                "rules" : {
                  "major" : {
                    "ruleType" : "=",
                    "version" : 2
                  },
                  "minor" : {
                    "ruleType" : "<",
                    "version" : 17
                  }
                }
              } ],
              "securityIssue" : [ {
                "comment" : "banished because of CVE-2021-44832",
                "groupId" : "org.apache.logging.log4j",
                "level" : "critical",
                "link" : "https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-4483",
                "rules" : {
                  "major" : {
                    "ruleType" : "=",
                    "version" : 2
                  },
                  "minor" : {
                    "ruleType" : "<",
                    "version" : 17
                  }
                }
              },
               
               {
                "comment" : "banished because of CVE-2016-1000027",
                "groupId" : "org.springframework",
                "artifactId": "spring-webmvc",
                "level" : "critical",
                "link" : "https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2016-1000027",
                "rules" : {
                  "major" : {
                    "ruleType" : "=",
                    "version" : 5
                  },
                  "minor" : {
                    "ruleType" : "<",
                    "version" : 4
                  }
                }
              }
               ]
            }
            """;

    @Override
    public DependenciesCheck getDependenciesCheckData() {

        try {
            return JsonMarshaller.getInstance()
                                 .getDefaultObjectMapper()
                                 .readValue(DATA, DependenciesCheck.class);
        } catch (final JsonProcessingException e) {
            throw new UncheckedException(e);
        }
    }
}
