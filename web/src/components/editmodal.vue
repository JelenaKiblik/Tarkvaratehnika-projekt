<template>
    <div id = 'editmodal'>
        <!-- modal content -->
        <md-dialog md-open-from="#add" md-close-to="#add" ref="dialog1">
            <md-dialog-title>Edit Recipe</md-dialog-title>

            <md-dialog-content>
                <form>
                    <md-input-container>
                        <label>Recipe name</label>
                        <md-textarea v-model='title' placeholder="Name"></md-textarea>
                    </md-input-container>
                    <md-input-container>
                        <label>Ingredients separated by commas</label>
                        <md-textarea placeholder = 'item1, item2...' v-model='ing'></md-textarea>
                    </md-input-container>
                </form>
            </md-dialog-content>

            <md-dialog-actions>
                <md-button class="md-primary" @click="closeDialog('dialog1')">Cancel</md-button>
                <md-button class="md-primary" @click="editItem('dialog1')">Edit Recipe</md-button>
            </md-dialog-actions>
        </md-dialog>
        <!-- end of modal content -->

        <!-- dialog button -->
        <md-button class="md-accent" @click="openDialog('dialog1')">
            Edit <md-icon class = "md-accent">edit</md-icon>
        </md-button>
        <!-- end of button -->
    </div>
</template>

<script>
    export default {
        name: 'editmodal',
        props: {
            "index": Number,
            "item": Object
        },
        data() {
            return {
                title: this.item.title,
                ing: this.item.ingredients.join(',')
            }
        },
        methods: {
            openDialog (ref) {
                this.$refs[ref].open()
            },
            closeDialog (ref) {
                this.$refs[ref].close()
            },
            onOpen () {
                console.log('Opened')
            },
            onClose (type) {
                console.log('Closed', type)
            },
            editItem (ref) {
                let item = {
                    id: this.index,
                    title: this.title,
                    ingredients: this.ing.split(',')
                }
                //emit edit event to parent - recipe
                this.$emit('edit', item)
                //console.log(item)
                this.closeDialog(ref)
                title = this.item.title
                ing =this.item.ingredients.join(',')
            }
        }
    }
</script>