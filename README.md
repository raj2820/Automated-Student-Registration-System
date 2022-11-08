# expert-chance-2924
<h1 align="center"> Project topic :- Automated Student Registration System .</h1>
<h3 align="center">Description :-</h3>
<p align="center"> In a Educational Institute every year  technology trainings are conducted during summer and winter season. Students are enrolled in different courses under different technology track like- Android, Java ,JEE, PHP, Oracle etc. This automated application help Institute to enroll students efficiently, create batches under a course and allocates the students  in a batch .  </p>





<h1 align="center"> Student table </h1>
<table align="center" text-align="center">
<tr>
<th> Field </th>
<th> Type  </th>
<th> Null </th>
<th>  Key </th>
<th>  Default </th>
<th>   Extra   </th>
</tr>
<tr>
<td>roll </td>
<td> int  </td>
<td>NO  </td>
<td> PRI</td>
<td>NULL  </td>
<td>auto_increment </td>
</tr>
<tr>
<td>name  </td>
<td> varchar(20) </td>
<td> YES </td>
<td> </td>
<td>NULL </td>
<td> </td>
</tr>
<tr>
<td>username  </td>
<td> varchar(20)</td>
<td>YES  </td>
<td> </td>
<td> NULL</td>
<td> </td>
</tr>
<tr>
<td> password</td>
<td>varchar(20) </td>
<td> YES </td>
<td> </td>
<td>NULL </td>
<td> </td>
</tr>
</table>

<h1 align="center">Course Table</h1>





<table align="center" text-align="center">
<tr>
<th> Field </th>
<th> Type  </th>
<th> Null </th>
<th>  Key </th>
<th>  Default </th>
<th>   Extra   </th>
</tr>
<tr>
<td>cid</td>
<td> int  </td>
<td>NO  </td>
<td> PRI</td>
<td>NULL  </td>
<td>auto_increment </td>
</tr>
<tr>
<td>cname  </td>
<td> varchar(20) </td>
<td> YES </td>
<td> </td>
<td>NULL </td>
<td> </td>
</tr>
<tr>
<td>fee  </td>
<td> int</td>
<td>YES  </td>
<td> </td>
<td> NULL</td>
<td> </td>
</tr>
<tr>
<td> duration</td>
<td>varchar(20) </td>
<td> YES </td>
<td> </td>
<td>NULL </td>
<td> </td>
</tr>
</table>
