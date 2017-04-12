function addSelectedItems(source, target) {
    var sourceList = document.getElementById(source);
    var targetList = document.getElementById(target);
    var selectedValues = sourceList.value || [];
    if (!(selectedValues instanceof Array)) {
        selectedValues = [selectedValues];
    }
    for (var i = 0; i < sourceList.children.length; i++) {
        var childNode = sourceList.children[i];
        if (selectedValues.indexOf(childNode.value) !== -1) {
            sourceList.removeChild(childNode);
            targetList.appendChild(childNode);
        }
    }
}/**
 * Created by kisc on 4/12/2017.
 */
