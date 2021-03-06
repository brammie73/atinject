define([],
function() {

	function UserCache() {
		this.elements = new Object();
	};

	UserCache.prototype.getUser = function(userId){
		return this.elements[userId];
	};

	UserCache.prototype.putUser = function(userId, user){
		this.elements[userId] = user;
	};

	UserCache.prototype.removeUser = function(userId){
		var user = this.elements[userId];
		delete this.elements[userId];
		return user;
	};

	UserCache.prototype.clear = function(){
		this.elements = new Object();
	};
	
	return new UserCache();
});
