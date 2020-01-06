public String details(String s) {
  try {
   String st = new String("select * from movie");
   ResultSet rs = statement.executeQuery(st);
   StringBuffer sb = new StringBuffer();
   sb.append("{'cmd':'101','code':'0','list':[");
   while (rs.next()) {
	Music m = new Music();
	m.setName();
    String name = rs.getString("name");
    String type = rs.getString("type");
    String time = rs.getString("time");
    String player = rs.getString("player");
    String image = rs.getString("image");
    String movieid = rs.getString("movieid");
    sb.append("{'mid':'" + movieid + "','name':'" + name + "','type':'" + type + "','time':'" + time
      + "','player':'" + player + "','image':'" + image + "'},");
   }
   sb.deleteCharAt(sb.length() - 1);
   sb.append("]}");
   s = sb.toString();
  } catch (Exception e) {
   e.printStackTrace();
  }
  return s;
 }
