/*
* Licensed to The Apereo Foundation under one or more contributor license
* agreements. See the NOTICE file distributed with this work for
* additional information regarding copyright ownership.
*
* The Apereo Foundation licenses this file to you under the Educational
* Community License, Version 2.0 (the "License"); you may not use this file
* except in compliance with the License. You may obtain a copy of the
* License at:
*
* http://opensource.org/licenses/ecl2.txt
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.sakaiproject.roster.api;

import java.util.Comparator;

import lombok.RequiredArgsConstructor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <code>Comparator</code> for <code>RosterMember</code>s.
 * 
 * @author d.b.robinson@lancaster.ac.uk
 */
@RequiredArgsConstructor
public class RosterMemberComparator implements Comparator<RosterMember> {

	private static final Log log = LogFactory.getLog(RosterMemberComparator.class);
	
	private final boolean firstNameLastName;
	
	/**
	 * Compares two <code>RosterMember</code> objects according to the sorting
	 * order configured in this instance of <code>RosterMemberComparator</code>.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(RosterMember member1, RosterMember member2) {

        if (firstNameLastName) {
            return member1.getDisplayName().compareToIgnoreCase(member2.getDisplayName());
        } else {
            return member1.getSortName().compareToIgnoreCase(member2.getSortName());
        }
	}
}
