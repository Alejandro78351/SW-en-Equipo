/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  App.Controller.UserController = Backbone.View.extend({
        el: '#main',
        initialize: function(options) {
            this.editTemplate = _.template($('#user').html());
            var self = this;
            Backbone.on('user-create', function(params) {
                self.create(params);
            });
            Backbone.on('user-save', function(params) {
                self.save(params);
            });
            Backbone.on('user-cancel', function(params) {
                self.cancel(params);
            });
        },
        create: function() {
            this.userModel = new App.Model.UserModel();
            this._renderEdit();
             $('#datepicker').datepicker();
        },
        save:function() { 
            var model = $('#userForm').serializeObject();
            var text = 'El usuario '+ model['firstName'] + ' ' + model['lastName'] + ' nació el ' + model['date'];
            var response = document.createElement('div');
            response.id = 'response';
            document.body.appendChild(response);
            response.setAttribute('style','width:89%; margin:auto;');
            response.appendChild(document.createTextNode(text));
        },
        cancel: function(){
            alert('Cancel');
        },
        _renderEdit: function() {
            var self = this;
            self.$el.html(self.editTemplate({user: self.userModel}));
        }
    });