/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.material.studies.rally

import androidx.ui.core.dp
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.FlexRow
import androidx.ui.layout.MainAxisAlignment
import androidx.ui.layout.Padding
import androidx.ui.layout.Row
import androidx.ui.material.Colors
import androidx.ui.material.StyledText
import androidx.ui.material.TransparentButton
import androidx.ui.material.studies.Divider
import androidx.ui.material.studies.Orientation
import androidx.ui.material.studies.Spacer
import androidx.ui.material.surface.Card
import androidx.ui.material.themeTextStyle
import androidx.ui.painting.Color
import com.google.r4a.Composable
import com.google.r4a.ambient
import com.google.r4a.composer
import com.google.r4a.unaryPlus

// TODO: This is not integrated with the theme
internal val cardInternalColor = Color(0xFF33333D.toInt())

/**
 * The Alerts card within the Rally Overview screen.
 */
@Composable
fun RallyAlertCard() {
    <Card color=cardInternalColor>
        <Padding padding=EdgeInsets(12.dp)>
            <Column>
                <Row mainAxisAlignment=MainAxisAlignment.SpaceBetween>
                    <StyledText text="Alerts" style=+themeTextStyle { subtitle2 }/>
                    <TransparentButton text="See All" onClick={} />
                </Row>
                <Padding padding=EdgeInsets(0.dp, 12.dp, 0.dp, 12.dp)>
                    val colors = +ambient(Colors)
                    <Divider color=colors.surface/>
                </Padding>
                <FlexRow>
                    expanded(flex = 1.0f) {
                        val text = "Heads up, you've used up 90% of your " +
                                "Shopping budget for this month."
                        <StyledText style=+themeTextStyle { body1 }
                                    text />
                    }
                    inflexible {
                        // TODO: icons still don't work
//                        <vectorResource res=context.resources
//                            resId=androidx.ui.material.studies.R.drawable.sort_icon/>
                        <TransparentButton text="Sort" onClick={} />
                    }
                </FlexRow>
            </Column>
        </Padding>
    </Card>
}

/**
 * The Accounts card within the Rally Overview screen.
 */
@Composable
fun RallyAccountsCard() {
    <Card color=cardInternalColor>
        <Column>
            <Padding padding=EdgeInsets(12.dp)>
                <Column>
                    <StyledText text="Accounts" style=+themeTextStyle { body1 }/>
                    <StyledText text="$12,132.49" style=+themeTextStyle { h3 }/>
                </Column>
            </Padding>
            <Divider color=rallyGreen size=1.dp/>
            <Padding padding=EdgeInsets(12.dp)>
                <Column>
                    val colors = +ambient(Colors)
                    <RallyAccountRow name="Checking" number="1234" amount="2,215.13"
                        color=Color(0xFF005D57)/>
                    <Divider color=colors.surface/>
                    <RallyAccountRow name="Home Savings" number="5678" amount="8,676.88"
                        color=Color(0xFF04B97F)/>
                    <Divider color=colors.surface/>
                    <RallyAccountRow name="Car Savings" number="9012" amount="987.48"
                        color=Color(0xFF37EFBA)/>
                    <Divider color=colors.surface/>
                    <TransparentButton text="See All" />
                </Column>
            </Padding>
        </Column>
    </Card>
}

/**
 * A row within the Accounts card in the Rally Overview screen.
 */
@Composable
fun RallyAccountRow(name: String, number: String, amount: String, color: Color) {
    <Padding padding=EdgeInsets(0.dp, 12.dp, 0.dp, 12.dp)>
        <FlexRow>
            inflexible {
                <AccountIndicator color=color/>
                <Spacer size=8.dp orientation=Orientation.Horizontal/>
                <Column crossAxisAlignment=MainAxisAlignment.Start>
                    <StyledText text=name style=+themeTextStyle { body1 }/>
                    <StyledText text="•••••$number" style=+themeTextStyle { subtitle1 }/>
                </Column>
            }
            expanded(flex = 1.0f) {
                <Container />
            }
            inflexible {
                <StyledText text="$ $amount" style=+themeTextStyle { h6 }/>
            }
        </FlexRow>
    </Padding>
}

/**
 * A vertical colored line that is used in a [RallyAccountRow] to differentiate accounts.
 */
@Composable
fun AccountIndicator(color: Color) {
    <Container color width=4.dp height=36.dp />
}

/**
 * The Bills card within the Rally Overview screen.
 */
@Composable
fun RallyBillsCard() {
    <Card color=cardInternalColor>
        <Column>
            <Padding padding=EdgeInsets(12.dp)>
                <Column>
                    <StyledText text="Bills" style=+themeTextStyle { subtitle2 }/>
                    <StyledText text="$1,810.00" style=+themeTextStyle { h1 } />
                </Column>
            </Padding>
        </Column>
    </Card>
}