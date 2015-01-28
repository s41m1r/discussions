/**
 * 
 */
package discussions;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;

/**
 * @author Saimir Bala
 *
 */
public class Test {
	
	public static void main(String[] args) throws FacebookException {
		Facebook facebook = new FacebookFactory().getInstance();
		
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true);
//		cb.setRestBaseURL("https://graph.facebook.com/v2.2/");
//		FacebookFactory ff = new FacebookFactory(cb.build());
//		Facebook facebook = ff.getInstance();
		
		///jhjhjhjhjh
		
		
		//jgjgjkg
		
		ResponseList<Group> groupList = facebook.getGroups(new Reading().limit(1000));
		
//		for (int i = 0; i < 2; i++) {
//			Paging<Group> currentPage = groupList.getPaging();
//			System.out.println("Current page = "+currentPage.getCursors());
//			System.out.println("Groups count = "+groupList.getCount()+" Last post of page " + (i+1) +" is "+ groupList.get(groupList.size()-1));
//		}
		
		Group selectedGroup = null;
		
		// Get the group
		for (Group group : groupList) {
	      if(group.getName().contains("Foreign")){
	      	selectedGroup = group;
	      	break;
	      }
	      selectedGroup = group;
      }
		
		System.out.println("Selected group: "+selectedGroup);
		
		// Get the feeds
		
		ResponseList<Post> feedList = facebook.getFeed(selectedGroup.getId());
		
		System.out.println("We have "+feedList.size()+" feeds. Here you go: ");
		for (Post post : feedList) {
			System.out.println("**** "+post.getFrom().getName()+ " wrote:");
	      System.out.println(post.getMessage()+ " on "+post.getUpdatedTime() + " and received "+post.getComments().size()+" comments");
	      PagableList<Comment> comments =  post.getComments();
	      for (Comment comment : comments) {
	      	System.out.println(" "+comment.getFrom().getName()+": "+ comment.getMessage());
         }
      }
		
		System.out.println("End.");
   }
	
}
