/* ========================================================================
 * Copyright 2014 Sebastian
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Sebastian

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/
define(['model/memberModel'], function(memberModel) {
    App.Controller._MemberController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#member').html());
            this.listTemplate = _.template($('#memberList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-member-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-member-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-member-create', {view: this});
                this.currentMemberModel = new this.modelClass({componentId: this.componentId});
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-member-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-member-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-member-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-member-list', {view: this, data: data});
                var self = this;
				if(!this.memberModelList){
                 this.memberModelList = new this.listModelClass();
				}
                this.memberModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-member-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'member-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-member-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-member-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-member-edit', {view: this, id: id, data: data});
                if (this.memberModelList) {
                    this.currentMemberModel = this.memberModelList.get(id);
                    this.currentMemberModel.set('componentId',this.componentId); 
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-member-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentMemberModel = new this.modelClass({id: id});
                    this.currentMemberModel.fetch({
                        data: data,
                        success: function() {
                            self.currentMemberModel.set('componentId',self.componentId); 
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-member-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'member-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-member-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-member-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-member-delete', {view: this, id: id});
                var deleteModel;
                if (this.memberModelList) {
                    deleteModel = this.memberModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-member-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'member-delete', view: self, error: error});
                    }
                });
            }
        },
		_loadRequiredComponentsData: function(callBack) {
            var self = this;
            var listReady = _.after(2, function(){
                callBack();
            }); 
            var listDataReady = function(componentName, model, aliasModel){
            if(aliasModel){
                self[aliasModel] = model;
            } else {
            	self[componentName] = model;
            }    
                listReady();
            };
				App.Utils.getComponentList('documentTypeComponent',listDataReady,'documentTypeComponent');
				App.Utils.getComponentList('memberComponent',listDataReady,'partnerComponent');
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-memberForm').serializeObject();
 
			 if(!model.enable){
			 	model.enable=false
			 } 
            if (App.Utils.eventExists(this.componentId + '-' +'instead-member-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-member-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-member-save', {view: this, model : model});
                this.currentMemberModel.set(model);
                this.currentMemberModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-member-save', {model: self.currentMemberModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'member-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({members: self.memberModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({member: self.currentMemberModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				    ,documentType: self.documentTypeComponent
 
				    ,partner: self.partnerComponent
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._MemberController;
});