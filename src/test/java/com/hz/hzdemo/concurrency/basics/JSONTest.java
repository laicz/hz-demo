package com.hz.hzdemo.concurrency.basics;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Create by zhoumingbing on 2019-09-06
 */
public class JSONTest {
    private static String str = "{\n" +
            "                            \"vertices\": [\n" +
            "                                {\n" +
            "                                    \"_tag\": \"START\",\n" +
            "                                    \"_id\": \"Company/D190EAA12456F9EB9365B0C524889EEC\",\n" +
            "                                    \"name\": \"上海致安电子有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司\",\n" +
            "                                    \"capital\": 3000000,\n" +
            "                                    \"address\": \"松江区邱家湾44号A区\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"计算机、通信和其他电子设备制造业\",\n" +
            "                                    \"business_status\": \"迁出\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/0FB02B4F3A8FFC90CD7856673BA991AA\",\n" +
            "                                    \"name\": \"上海国纪电子有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司(台港澳与境内合资)\",\n" +
            "                                    \"capital\": 7600000,\n" +
            "                                    \"address\": \"上海市松江工业区宝胜路33号\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"机械和器材设备制造业\",\n" +
            "                                    \"business_status\": \"其他\",\n" +
            "                                    \"utime\": \"2019-04-25 01:05:32\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/5719D3DB965CBBAA9DB149ABD7202570\",\n" +
            "                                    \"name\": \"上海云灏广告有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（自然人投资或控股）\",\n" +
            "                                    \"capital\": 10000000,\n" +
            "                                    \"address\": \"上海市奉贤区四团镇安泰路38号1幢102室\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"注销\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"name\": \"金安国纪科技股份有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（外商投资企业法人独资）\",\n" +
            "                                    \"capital\": 50000000,\n" +
            "                                    \"address\": \"上海市松江区九亭镇九新公路339号1幢14楼\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"房地产业\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/7D3752639484929C3DE7E4B7371DF647\",\n" +
            "                                    \"name\": \"上海东临投资发展有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（自然人投资或控股）\",\n" +
            "                                    \"capital\": 50000000,\n" +
            "                                    \"address\": \"上海市浦东新区杨高北路528号14幢3001室\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/2D91031DCEC6799443788ED732622174\",\n" +
            "                                    \"name\": \"上海海齐投资咨询有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（自然人投资或控股）\",\n" +
            "                                    \"capital\": 10000000,\n" +
            "                                    \"address\": \"上海市崇明区城桥镇官山路2号3幢C区2096室（崇明工业园区）\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/82CA46BD2FF652DA90C0AFCE2CC365BF\",\n" +
            "                                    \"name\": \"金安国纪投资有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（外商投资企业法人独资）\",\n" +
            "                                    \"capital\": 100000000,\n" +
            "                                    \"address\": \"上海市崇明县北沿公路2111号3幢145-5室（上海崇明森林旅游园区）\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/75A1A119DDE588DB14D037EC972030E6\",\n" +
            "                                    \"name\": \"上海开诚投资有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（外商投资企业法人独资）\",\n" +
            "                                    \"capital\": 30000000,\n" +
            "                                    \"address\": \"中国（上海）自由贸易试验区东方路738号901室\",\n" +
            "                                    \"province\": \"上海\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/5A5F403D1EDE4DDAECEB80003710314C\",\n" +
            "                                    \"name\": \"宁波杉杉创业投资有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司（自然人投资或控股的法人独资）\",\n" +
            "                                    \"capital\": 30000000,\n" +
            "                                    \"address\": \"浙江省宁波市北仑区梅山七星路88号1幢401室A区A1018\",\n" +
            "                                    \"province\": \"浙江\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"存续\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/078C41B262083E78BAD802A43694A345\",\n" +
            "                                    \"name\": \"深圳杉汇通互联网金融服务有限公司\",\n" +
            "                                    \"enterprise_type\": \"有限责任公司\",\n" +
            "                                    \"capital\": 101100000,\n" +
            "                                    \"address\": \"深圳市福田区福田街道深南中路国际文化大厦2903A\",\n" +
            "                                    \"province\": \"广东\",\n" +
            "                                    \"industry\": \"互联网和相关服务\",\n" +
            "                                    \"business_status\": \"存续（在营、开业、在册）\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Company/066C41B262083E78BAD802A43694A52A\",\n" +
            "                                    \"name\": \"南通杉创创业投资中心（有限合伙）\",\n" +
            "                                    \"enterprise_type\": \"有限合伙企业\",\n" +
            "                                    \"capital\": 137800000,\n" +
            "                                    \"address\": \"海安县城东镇晓星大道8号1幢2F-02室\",\n" +
            "                                    \"province\": \"江苏\",\n" +
            "                                    \"industry\": \"商务服务业\",\n" +
            "                                    \"business_status\": \"在业\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"6\",\n" +
            "                                        \"color\": \"#2196f3\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/04B3F01D1428DC09DB23FC7AAE892C19\",\n" +
            "                                    \"name\": \"周昌生\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/D261409DAA7A7B6E009A16CB22B51E2E\",\n" +
            "                                    \"name\": \"帅新苗\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/BE177639192989034B4AD1AD03A1F44F\",\n" +
            "                                    \"name\": \"方亚楠\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/F9D6FE5896D554174D11F63BA6BEC237\",\n" +
            "                                    \"name\": \"韩涛\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/95302C699E9D5E70F24387D3A360C228\",\n" +
            "                                    \"name\": \"程敬\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/5151BBC5AE268D0543C5704EF9A9AD1A\",\n" +
            "                                    \"name\": \"韩薇\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_tag\": \"\",\n" +
            "                                    \"_id\": \"Person/FED97FC3ECC098753082E2958478F6ED\",\n" +
            "                                    \"name\": \"孙伟\",\n" +
            "                                    \"ctime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"utime\": \"2019-05-31 01:19:00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"style\": \"10\",\n" +
            "                                        \"color\": \"#00bcd4\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"edges\": [\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/066C41B262083E78BAD802A43694A52A\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/E90293EEF8479044EC97353D9E0929D4\",\n" +
            "                                    \"invest_amount\": \"投资5000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/078C41B262083E78BAD802A43694A345\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/E90293EEF8479044EC97353D9E0929D4\",\n" +
            "                                    \"invest_amount\": \"投资5000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/D190EAA12456F9EB9365B0C524889EEC\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/E90293EEF8479044EC97353D9E0929D3\",\n" +
            "                                    \"invest_amount\": \"投资5670000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/5A5F403D1EDE4DDAECEB80003710314C\",\n" +
            "                                    \"_to\": \"Company/066C41B262083E78BAD802A43694A52A\",\n" +
            "                                    \"_id\": \"invest/6BF293C70664DD78BEABB8CEDB9BE1E9\",\n" +
            "                                    \"invest_amount\": \"投资1000000000\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/5A5F403D1EDE4DDAECEB80003710314C\",\n" +
            "                                    \"_to\": \"Company/51715DEF9A579B2ACF682E414C9AC500\",\n" +
            "                                    \"_id\": \"invest/E8D1D26D8F86532A00FC46CD6BD1F63C\",\n" +
            "                                    \"invest_amount\": \"投资15670000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/12C799C6996A52AB2B1F90BC753F877A\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/5E32B1EAEC1732F4B6E3F0F097340B04\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/010B710DD806A40E6C2865E10E62D824\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/777BB0B2E1C59A13CCA75BC1632AE80B\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/95302C699E9D5E70F24387D3A360C228\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/8EC4905FA3E53083483585F07DA8A668\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/D261409DAA7A7B6E009A16CB22B51E2E\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/C78FD7FDCCBC59937199DC43F489FE20\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/F9D6FE5896D554174D11F63BA6BEC237\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/1A8D47B7E48609B07AF0F677C394A000\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/FED97FC3ECC098753082E2958478F6ED\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/6ECD767A7A474EDC971C3E8012FB90F6\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/50FC3B264B946BB71D1183CF30E590F0\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/751EBCEB40AA93A208FE09C14E72D3FA\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/F9D6FE5896D554174D11F63BA6BEC237\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/EDE799DE40D1AE7B4ACC78E49324CFF9\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/C5D18286B627176BEBF5CC32FB3E71B7\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/72CB61E81C0AB8F67344D54E8410EFCF\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/50E8CE9BC87AB4F45096C6595509A30D\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/221B0FF2EBDF2A7A5B8A96F1E10BB802\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/F9D6FE5896D554174D11F63BA6BEC237\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/8D362EA75ECBD72358537409A6E86550\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/BE177639192989034B4AD1AD03A1F44F\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/867E351F7D0E45E369BCA7BE726565AB\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/5151BBC5AE268D0543C5704EF9A9AD1A\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/DF046C5D7EF5EDDFDD32EB4893FFB11A\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Person/04B3F01D1428DC09DB23FC7AAE892C19\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"officer/9FC2B623576D03B63E4B251AE6EE935C\",\n" +
            "                                    \"postion\": \"高管\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_to\": \"Company/BD508F21FC535962870D0A2BFC8530E8\",\n" +
            "                                    \"_id\": \"invest/598813461892DE8ABC077DBCDBC02436\",\n" +
            "                                    \"invest_amount\": \"投资50000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_to\": \"Company/61015E99DB8797D7B3004D480A97C592\",\n" +
            "                                    \"_id\": \"invest/EE06324772D32CAABAA4131BDFB7FFE3\",\n" +
            "                                    \"invest_amount\": \"投资100000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_to\": \"Company/33581823FD4C7CD2A5907235AF98E392\",\n" +
            "                                    \"_id\": \"invest/07CD76D0B32E1162B087CDBDF2AD8801\",\n" +
            "                                    \"invest_amount\": \"投资1000000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_to\": \"Company/82CA46BD2FF652DA90C0AFCE2CC365BF\",\n" +
            "                                    \"_id\": \"invest/0B4D097BBBE679132641855ADD29BE07\",\n" +
            "                                    \"invest_amount\": \"投资200000000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_to\": \"Company/0FB02B4F3A8FFC90CD7856673BA991AA\",\n" +
            "                                    \"_id\": \"invest/7EA529A8274364C671D083831605754D\",\n" +
            "                                    \"invest_amount\": \"投资5700000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/2D91031DCEC6799443788ED732622174\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/FC98CEAA7BF9E455A803936D250239A7\",\n" +
            "                                    \"invest_amount\": \"投资2100000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/02FE51327DC4057962A786105D23542B\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/1A80CE700FAC1917D13EFD1276576842\",\n" +
            "                                    \"invest_amount\": \"投资占比34.20%，投资71820000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/5719D3DB965CBBAA9DB149ABD7202570\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/3A308EADD0365FE37962F346F3F94722\",\n" +
            "                                    \"invest_amount\": \"投资占比1.00%，投资2100000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/75A1A119DDE588DB14D037EC972030E6\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/ED10701E831D61D326000EEB9903DBCC\",\n" +
            "                                    \"invest_amount\": \"投资占比1.00%，投资2100000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"_from\": \"Company/7D3752639484929C3DE7E4B7371DF647\",\n" +
            "                                    \"_to\": \"Company/74D8212E72225BB9E75DD12499AA79D4\",\n" +
            "                                    \"_id\": \"invest/5B763B1DD4E704E349352216A50FE2A9\",\n" +
            "                                    \"invest_amount\": \"投资占比53.10%，投资111510000.00\",\n" +
            "                                    \"_uiConfig\": {\n" +
            "                                        \"color\": \"#f44336\",\n" +
            "                                        \"size\": \"NORMAL\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"schemas\": [\n" +
            "                                {\n" +
            "                                    \"schema\": \"Person\",\n" +
            "                                    \"schemaNameCn\": \"自然人\",\n" +
            "                                    \"type\": \"VERTEX\",\n" +
            "                                    \"displayField\": \"name\",\n" +
            "                                    \"fields\": [\n" +
            "                                        {\n" +
            "                                            \"field\": \"name\",\n" +
            "                                            \"fieldNameCn\": \"姓名\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"object_key\",\n" +
            "                                            \"fieldNameCn\": \"object_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"ctime\",\n" +
            "                                            \"fieldNameCn\": \"创建时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"utime\",\n" +
            "                                            \"fieldNameCn\": \"更新时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        }]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"Company\",\n" +
            "                                    \"schemaNameCn\": \"企业\",\n" +
            "                                    \"type\": \"VERTEX\",\n" +
            "                                    \"displayField\": \"name\",\n" +
            "                                    \"fields\": [\n" +
            "                                        {\n" +
            "                                            \"field\": \"name\",\n" +
            "                                            \"fieldNameCn\": \"公司名称\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"object_key\",\n" +
            "                                            \"fieldNameCn\": \"object_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"address\",\n" +
            "                                            \"fieldNameCn\": \"公司地址\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"enterprise_type\",\n" +
            "                                            \"fieldNameCn\": \"企业类型\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"reg_address\",\n" +
            "                                            \"fieldNameCn\": \"注册地址\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"capital\",\n" +
            "                                            \"fieldNameCn\": \"注册资本\",\n" +
            "                                            \"type\": \"DOUBLE\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"business_status\",\n" +
            "                                            \"fieldNameCn\": \"经营状态\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"industry\",\n" +
            "                                            \"fieldNameCn\": \"行业\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"province\",\n" +
            "                                            \"fieldNameCn\": \"省份\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"utime\",\n" +
            "                                            \"fieldNameCn\": \"更新时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"officer\",\n" +
            "                                    \"schemaNameCn\": \"高管\",\n" +
            "                                    \"type\": \"EDGE\",\n" +
            "                                    \"displayField\": \"position\",\n" +
            "                                    \"fields\": [\n" +
            "                                        {\n" +
            "                                            \"field\": \"position\",\n" +
            "                                            \"fieldNameCn\": \"职位\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"object_key\",\n" +
            "                                            \"fieldNameCn\": \"object_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"from_key\",\n" +
            "                                            \"fieldNameCn\": \"from_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"to_key\",\n" +
            "                                            \"fieldNameCn\": \"to_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"ctime\",\n" +
            "                                            \"fieldNameCn\": \"创建时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"utime\",\n" +
            "                                            \"fieldNameCn\": \"更新时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"invest\",\n" +
            "                                    \"schemaNameCn\": \"投资\",\n" +
            "                                    \"type\": \"EDGE\",\n" +
            "                                    \"displayField\": \"invest_amount\",\n" +
            "                                    \"fields\": [\n" +
            "                                        {\n" +
            "                                            \"field\": \"ctime\",\n" +
            "                                            \"fieldNameCn\": \"创建时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"utime\",\n" +
            "                                            \"fieldNameCn\": \"更新时间\",\n" +
            "                                            \"type\": \"DATETIME\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"object_key\",\n" +
            "                                            \"fieldNameCn\": \"object_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"from_key\",\n" +
            "                                            \"fieldNameCn\": \"from_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"to_key\",\n" +
            "                                            \"fieldNameCn\": \"to_key\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"field\": \"invest_amount\",\n" +
            "                                            \"fieldNameCn\": \"投资金额\",\n" +
            "                                            \"type\": \"STRING\"\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }],\n" +
            "                            \"uiConfigs\": [\n" +
            "                                {\n" +
            "                                    \"schema\": \"Company\",\n" +
            "                                    \"style\": \"9\",\n" +
            "                                    \"color\": \"#2196f3\",\n" +
            "                                    \"size\": \"SMALL\"\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"Person\",\n" +
            "                                    \"style\": \"6\",\n" +
            "                                    \"color\": \"#9c27b0\",\n" +
            "                                    \"size\": \"SMALL\"\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"officer\",\n" +
            "                                    \"style\": \"\",\n" +
            "                                    \"color\": \"#7BC2BC\",\n" +
            "                                    \"size\": \"SMALL\"\n" +
            "\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"schema\": \"invest\",\n" +
            "                                    \"style\": \"\",\n" +
            "                                    \"color\": \"#358C85\",\n" +
            "                                    \"size\": \"LARGE\"\n" +
            "\n" +
            "                                }\n" +
            "                            ]\n" +
            "\n" +
            "                        }";

    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
    }
}
