/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.Utils

import java.io._

object WaveReport {

  def buildWaveHTMLReport(status: String, pageTitle: String, alertCount: Int, errorCount: Int, waveReportFlag: String, pageUrl: String): Unit = {
    if(waveReportFlag == "N") {
      val writer = new PrintWriter("target/wave-reports/index.html", "UTF-8")
      writerHelper(writer, status, pageTitle, alertCount, errorCount, waveReportFlag, pageUrl)
    }
    else {
      val writer = new PrintWriter(new BufferedWriter(new FileWriter("target/wave-reports/index.html", true)))
      writerHelper(writer, status, pageTitle, alertCount, errorCount, waveReportFlag, pageUrl)
    }
  }

  def writerHelper(writer: PrintWriter, status: String, pageTitle: String, alertCount: Int, errorCount: Int, waveReportFlag: String, pageUrl: String): Unit = {
    writer.println("<tr>")
    writer.println(s"""<td><a href="$pageUrl">$pageTitle</a></td>""")
    writer.println(s"""<td style="background-color: #FFD700; text-align: center;">$alertCount</td>""")
    writer.println(s"""<td style="background-color: #FF0000; text-align: center;">$errorCount</td>""")
    if(status == "Failed") {
      writer.println(s"""<td style="background-color: #D88A8A; text-align: center;">$status</td>""")
    }
    else {
      writer.println(s"""<td style="background-color: #C5D88A; text-align: center;">$status</td>""")
    }
    writer.println("</tr>")
    writer.close()
  }

  def createAccessibilityReport(): Unit = {
    val headerText =
      """
        |<!DOCTYPE html>
        |<html xmlns="http://www.w3.org/1999/xhtml">
        |
        |<head>
        |  <meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
        |  <title>Wave Accessibility Test Report</title>
        |</head>
        |
        |<body id="top" bgcolor="#E6E6FA">
        |  <div id="fullwidth_header">
        |    <div class="container_12">
        |      <h1><font color="#228B22" size="30">Wave Accessibility Test Report</font></h1>
        |      <img src="wavelogo.png" alt="Wave Logo" style="width:304px;height:100px">
        |      <br/>
        |      <div class="grid_12 hr"></div>
        |      <div>
        |        <br/>
        |        <h2><font color="#228B22">Feature Statistics</font></h2>
        |        <table style="border-collapse:collapse" border="1">
        |          <tr>
        |            <th style="text-align:left">Page Title</th>
        |            <th style="text-align:left">Alerts</th>
        |            <th style="text-align:left">Errors</th>
        |            <th style="text-align:left">Status</th>
        |          </tr>
      """.stripMargin

    val footerText =
      """
        |        </table>
        |      </div>
        |    </div>
        |  </div>
        |</body>
        |
        |</html>
      """.stripMargin

    val reader = new BufferedReader(new FileReader("target/wave-reports/index.html"))

    val sb = new StringBuilder()
    var line: String = reader.readLine()
    while (line != null) {
      sb.append(line)
      sb.append(System.lineSeparator())
      line = reader.readLine()
    }

    val tableContent = sb.toString
    val fileContent = headerText + tableContent + footerText
    val writer = new PrintWriter("target/wave-reports/index.html", "UTF-8")
    writer.println(fileContent)
    writer.close()
  }
}
