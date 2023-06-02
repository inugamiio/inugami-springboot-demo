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
package io.inugami.springboot.demo.user.infrastructure.configuration;

import io.inugami.maven.plugin.analysis.front.api.services.DependenciesCheckService;
import io.inugami.springboot.demo.user.infrastructure.service.release.note.ProjectDependenciesCheck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InugamiConfiguration {

    @Primary
    @Bean
    public DependenciesCheckService projectDependenciesCheck(){
        return new ProjectDependenciesCheck();
    }
}
